package com.aluracursos.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record CreateTopicRequest(
        @NotNull
        String title,
        @NotNull
        String message,
        @NotNull
        String status,
        @NotNull
        Long author_id,
        @NotNull
        Long course_id
) {
}
