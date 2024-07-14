package com.aluracursos.forohub.domain.topic.validations;

import com.aluracursos.forohub.domain.topic.CreateTopicRequest;

public interface TopicValidations {
    public void validate(CreateTopicRequest createTopicRequest);
}