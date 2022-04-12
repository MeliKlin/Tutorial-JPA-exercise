package com.exercicio.tutoriais.controllers;

import com.exercicio.tutoriais.TutorialRepository;
import com.exercicio.tutoriais.dtos.CreateTutorialDTO;
import com.exercicio.tutoriais.dtos.UpdateTutorialDTO;
import com.exercicio.tutoriais.errors.TutorialNotFoundException;
import com.exercicio.tutoriais.models.Tutorial;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TutorialsController {

    private TutorialRepository tutorialRepository;

    @PostMapping("/api/tutorials")
    public ResponseEntity<Void> createTutorial(
            @Valid @RequestBody CreateTutorialDTO tutorialDTO,
            UriComponentsBuilder uriBuilder
    ) {
        Tutorial tutorial = tutorialDTO.mountTutorial();
        Tutorial tutorialCreated = tutorialRepository.save(tutorial);

        URI uri = uriBuilder.path("/api/tutorials/{id}")
                .buildAndExpand(tutorialCreated.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/api/tutorials")
    public ResponseEntity<List<Tutorial>> listTutorials() {
        return ResponseEntity.ok(tutorialRepository.findAll());
    }

    @GetMapping("/api/tutorials/{id}")
    public ResponseEntity<Optional<Tutorial>> findTutorialById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(tutorialRepository.findById(id));
    }

    @PutMapping("/api/tutorials/{id}")
    public ResponseEntity<Void> updateTutorial(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateTutorialDTO updateTutorialDTO
    ) throws TutorialNotFoundException {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);
        if (tutorial.isEmpty()) {
            throw new TutorialNotFoundException("Tutorial não encontrado pelo ID informado");
        }

        updateTutorialDTO.mountTutorialToBeUpdated(tutorial.get());
        tutorialRepository.saveAndFlush(tutorial.get());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("api/tutorials")
    public ResponseEntity<Void> deleteAllTutorials() {
        tutorialRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/tutorials/{id}")
    public ResponseEntity<Void> deleteTutorialById(
            @PathVariable UUID id
    ) {
        tutorialRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ping")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("Pong");
    }

}
