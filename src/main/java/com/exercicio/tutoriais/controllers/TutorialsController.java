package com.exercicio.tutoriais.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialsController {

    @GetMapping("/ping")
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("Pong");
    }

}
