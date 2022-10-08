package com.quizapp.questiontag;

import com.quizapp.shared.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class QuestionTag extends BaseEntity {

    private String name;

}
