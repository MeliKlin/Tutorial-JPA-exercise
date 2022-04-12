package com.exercicio.tutoriais.controllers.advisor;

import com.exercicio.tutoriais.errors.TutorialNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvisor {

    @ExceptionHandler(value = TutorialNotFoundException.class)
    protected ResponseEntity<Object> handleException(TutorialNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
