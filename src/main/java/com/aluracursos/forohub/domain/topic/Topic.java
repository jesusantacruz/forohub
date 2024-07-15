package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.course.Course;
import com.aluracursos.forohub.domain.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Topic(CreateTopicRequest createTopicRequest) {
        this.title = createTopicRequest.title();
        this.message = createTopicRequest.message();
        this.creationDate = createTopicRequest.creationDate();
        this.status = createTopicRequest.status();
    }
}
