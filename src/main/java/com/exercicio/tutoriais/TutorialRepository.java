package com.exercicio.tutoriais;

import com.exercicio.tutoriais.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TutorialRepository extends JpaRepository<Tutorial, UUID> {
}
