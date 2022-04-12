package com.exercicio.tutoriais.controllers.advisor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionAdvisor {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
