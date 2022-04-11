package com.exercicio.tutoriais.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class Tutorial {

    private UUID id;
    private String title;
    private String description;
    private String situation;

}
