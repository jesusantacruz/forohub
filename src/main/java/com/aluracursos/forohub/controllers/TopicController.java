package com.aluracursos.forohub.controllers;

import com.aluracursos.forohub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
}
