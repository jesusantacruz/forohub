package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTopicService {
    @Autowired
    private TopicRepository topicRepository;

    public void delete(Long id) {
        if(!topicRepository.findById(id).isPresent()){
            throw new IntegrityValidation("Este id para el topico no existe");
        }
        topicRepository.deleteById(id);
    }
}
