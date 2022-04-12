package com.exercicio.tutoriais.dtos;

import com.exercicio.tutoriais.models.Tutorial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class CreateTutorialDTO {

    @NotEmpty(message = "Campo tutorial não pode estar vazio.")
    private String title;
    @NotEmpty(message = "Campo descrição não pode estar vazio")
    private String description;
    private boolean published = false;

    public Tutorial mountTutorial() {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        tutorial.setPublished(published);

        return tutorial;
    }

}
