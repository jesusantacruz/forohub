package com.aluracursos.forohub.domain.topic.validations;

import com.aluracursos.forohub.domain.topic.CreateTopicRequest;
import com.aluracursos.forohub.domain.users.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserExists implements CreateTopicValidations {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(CreateTopicRequest createTopicRequest) {
        if(createTopicRequest.authorId() == null){
            return;
        }
        var courseRegistered = userRepository.existsById(createTopicRequest.authorId());
        if(!courseRegistered){
            throw new ValidationException("No existe el id del usuario");
        }
    }
}
