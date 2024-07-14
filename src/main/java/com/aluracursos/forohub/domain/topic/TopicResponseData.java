package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.users.UserResponseData;
import com.aluracursos.forohub.domain.course.CourseResponseData;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TopicResponseData(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String status,
        UserResponseData userResponseData,
        CourseResponseData courseResponsedata
) {
    public TopicResponseData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), new UserResponseData(topic.getAuthor()), new CourseResponseData(topic.getCourse()));
    }
}
