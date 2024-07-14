package com.aluracursos.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateTopicRequest(
        @NotNull
        String title,
        @NotNull
        String message,
        @NotNull
        String status,
        @NotNull
        Long authorId,
        @NotNull
        Long courseId,
        @NotNull
        LocalDateTime creationDate
) {
}
