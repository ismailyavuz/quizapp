package com.quizapp.userquestion;

import com.quizapp.question.Question;
import com.quizapp.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
public class UserQuestion {

    @EmbeddedId
    private UserQuestionId id = new UserQuestionId();

    @CreatedDate
    private Date createdAt;

    private boolean correct;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("questionId")
    private Question question;
}
