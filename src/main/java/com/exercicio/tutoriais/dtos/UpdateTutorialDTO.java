package com.exercicio.tutoriais.dtos;

import com.exercicio.tutoriais.models.Tutorial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class UpdateTutorialDTO {

    private String title = "";
    private String description = "";
    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "Allowed input: true or false")
    private String published;

    public void mountTutorialToBeUpdated(Tutorial oldTutorial) {

        if (!title.equals("")) {
            oldTutorial.setTitle(title);
        }

        if (!description.equals("")) {
            oldTutorial.setDescription(description);
        }

        oldTutorial.setPublished(Boolean.parseBoolean(published));
    }

}
