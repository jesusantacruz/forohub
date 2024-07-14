package com.aluracursos.forohub.domain.topic.validations;

import com.aluracursos.forohub.domain.course.CourseRepository;
import com.aluracursos.forohub.domain.topic.CreateTopicRequest;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseExists implements TopicValidations {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(CreateTopicRequest createTopicRequest) {
        if(createTopicRequest.authorId() == null){
            return;
        }
        var courseRegistered = courseRepository.existsById(createTopicRequest.authorId());
        if(!courseRegistered){
            throw new ValidationException("No existe el id del curso");
        }
    }
}
