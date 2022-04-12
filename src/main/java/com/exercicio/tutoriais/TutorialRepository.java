package com.exercicio.tutoriais;

import com.exercicio.tutoriais.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TutorialRepository extends JpaRepository<Tutorial, UUID> {

    List<Tutorial> findAllByPublished(boolean published);
    @Query(value = "SELECT * FROM tutorial t WHERE t.title LIKE %?1%", nativeQuery = true)
    List<Tutorial> findAllByTitle(String title);

}
