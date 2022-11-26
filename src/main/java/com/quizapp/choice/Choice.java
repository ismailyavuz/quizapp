package com.quizapp.choice;

import com.quizapp.question.Question;
import com.quizapp.shared.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Choice extends BaseEntity {

    @ManyToOne
    private Question question;

    private String choiceText;

    private boolean correct;

}
