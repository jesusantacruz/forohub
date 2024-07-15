package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTopicService {
    @Autowired
    private TopicRepository topicRepository;

    public TopicResponseData show(Long id) {
        if(!topicRepository.findById(id).isPresent()){
            throw new IntegrityValidation("este id para el paciente no fue encontrado");
        }
        return new TopicResponseData(topicRepository.findById(id).get());
    }
}
