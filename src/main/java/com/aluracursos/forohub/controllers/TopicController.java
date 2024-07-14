package com.aluracursos.forohub.controllers;

import com.aluracursos.forohub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private CreateTopicService createTopicService;

    @PostMapping
    @Transactional

    public ResponseEntity<TopicResponseData> courseRegister(@RequestBody @Valid CreateTopicRequest createTopicRequest,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        TopicResponseData topic = createTopicService.create(createTopicRequest);

        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();
        return ResponseEntity.created(url).body(topic);
    }
}
