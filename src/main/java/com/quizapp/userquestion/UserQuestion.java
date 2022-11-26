package com.quizapp.userquestion;

import com.quizapp.question.Question;
import com.quizapp.user.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
