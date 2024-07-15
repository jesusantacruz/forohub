package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.course.CourseRepository;
import com.aluracursos.forohub.domain.topic.validations.CourseExists;
import com.aluracursos.forohub.domain.topic.validations.UserExists;
import com.aluracursos.forohub.domain.users.UserRepository;
import com.aluracursos.forohub.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseExists courseExistsValidation;

    @Autowired
    private UserExists userExistsValidation;

    public TopicResponseData update(UpdateTopicRequest updateTopicRequest) {
        if(!topicRepository.findById(updateTopicRequest.id()).isPresent()){
            throw new IntegrityValidation("Este id para el topico no existe");
        }

        var topic = topicRepository.findById(updateTopicRequest.id()).get();

        if(updateTopicRequest.authorId() != null) {
            userExistsValidation.validate(new CreateTopicRequest(null, null, null, updateTopicRequest.authorId(), null, null));
            var author = userRepository.findById(updateTopicRequest.authorId()).get();
            topic.setAuthor(author);
        }

        if(updateTopicRequest.courseId() != null) {
            courseExistsValidation.validate(new CreateTopicRequest(null, null, null, null, updateTopicRequest.courseId(), null));
            var course = courseRepository.findById(updateTopicRequest.courseId()).get();
            topic.setCourse(course);
        }

        if(updateTopicRequest.title() != null) {
            topic.setTitle(updateTopicRequest.title());
        }

        if(updateTopicRequest.message() != null) {
            topic.setMessage(updateTopicRequest.message());
        }

        if(updateTopicRequest.status() != null) {
            topic.setStatus(updateTopicRequest.status());
        }

        if(updateTopicRequest.creationDate() != null) {
            topic.setCreationDate(updateTopicRequest.creationDate());
        }

        topicRepository.save(topic);

        return new TopicResponseData(topic);
    }
}
