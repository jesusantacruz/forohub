package com.aluracursos.forohub.domain.course;

public record CourseResponseData(Long id, String name) {
    public CourseResponseData(Course course) {
        this(course.getId(), course.getName());
    }
}
