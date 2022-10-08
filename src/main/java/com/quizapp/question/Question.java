package com.quizapp.question;

import com.quizapp.questiontag.QuestionTag;
import com.quizapp.shared.entities.BaseEntity;
import com.quizapp.userquestion.UserQuestion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Question extends BaseEntity {

    private String langCode;
    private String questionText;

    @ManyToMany
    private List<QuestionTag> questionTags;

    @OneToMany(mappedBy = "question")
    List<UserQuestion> users;

}
