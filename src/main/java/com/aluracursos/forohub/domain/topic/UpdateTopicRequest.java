package com.aluracursos.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicRequest(
        String title,
        String message,
        String status,
        Long author_id,
        Long course_id
) {
}
