package com.quizapp.questiontag;

import com.quizapp.shared.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QuestionTag extends BaseEntity {

    private String name;

}
