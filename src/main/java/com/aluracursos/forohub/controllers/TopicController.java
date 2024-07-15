package com.aluracursos.forohub.controllers;

import com.aluracursos.forohub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.sql.Delete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CreateTopicService createTopicService;

    @Autowired
    private ShowTopicService showTopicService;

    @Autowired
    private UpdateTopicService updateTopicService;

    @Autowired
    private DeleteTopicService deleteTopicService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicResponseData> courseRegister(@RequestBody @Valid CreateTopicRequest createTopicRequest,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        TopicResponseData topic = createTopicService.create(createTopicRequest);

        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();
        return ResponseEntity.created(url).body(topic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseData> showTopic(@PathVariable Long id) {
        return ResponseEntity.ok(showTopicService.show(id));
    }

    @Transactional
    @PutMapping()
    public ResponseEntity<TopicResponseData> updateTopic(@RequestBody UpdateTopicRequest updateTopicRequest) {
        return ResponseEntity.ok(updateTopicService.update(updateTopicRequest));
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponseData>> list(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        var page = topicRepository.findAll(pagination).map(TopicResponseData::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        deleteTopicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
