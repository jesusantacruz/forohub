package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.course.CourseRepository;
import com.aluracursos.forohub.domain.topic.validations.CreateTopicValidations;
import com.aluracursos.forohub.domain.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateTopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRespository;

    @Autowired
    private List<CreateTopicValidations> validators;

    public TopicResponseData create(CreateTopicRequest createTopicRequest) {
        validators.forEach(v-> v.validate(createTopicRequest));
        var author = userRepository.findById(createTopicRequest.authorId()).get();
        var course = courseRepository.findById(createTopicRequest.courseId()).get();

        var topic = new Topic(createTopicRequest);
        topic.setAuthor(author);
        topic.setCourse(course);

        topicRespository.save(topic);
        return new TopicResponseData(topic);
    }
}
