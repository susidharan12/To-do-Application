package dev.codeio.Todo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Schema(example = "Complete Spring Boot")
    private String title;


    @Column(nullable = false)
    private Boolean isCompleted = false;
}
