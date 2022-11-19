package com.quizapp.choice;

import com.quizapp.question.Question;
import com.quizapp.shared.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Getter
@Setter
@Entity
public class Choice extends BaseEntity {

    @ManyToOne
    private Question question;

    private String choiceText;

    private boolean correct;

}
