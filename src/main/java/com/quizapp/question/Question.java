package com.quizapp.question;

import com.quizapp.questiontag.QuestionTag;
import com.quizapp.shared.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Question extends BaseEntity {

    private String langCode;
    private String questionText;

    @ManyToMany
    private List<QuestionTag> questionTags;

}
