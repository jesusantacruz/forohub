package com.aluracursos.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateTopicRequest(
        Long id,
        String title,
        String message,
        String status,
        Long authorId,
        Long courseId,
        LocalDateTime creationDate
) {
}
