package com.exercicio.tutoriais.controllers;

import com.exercicio.tutoriais.TutorialRepository;
import com.exercicio.tutoriais.models.Tutorial;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
            @RequestBody Tutorial tutorial,
            UriComponentsBuilder uriBuilder
    ) {
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

    @GetMapping("/ping")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("Pong");
    }

}
