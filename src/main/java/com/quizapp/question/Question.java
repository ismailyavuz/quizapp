package com.quizapp.question;

import com.quizapp.choice.Choice;
import com.quizapp.questiontag.QuestionTag;
import com.quizapp.shared.entities.BaseEntity;
import com.quizapp.userquestion.UserQuestion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinTable(name="question_question_tag",
    joinColumns = @JoinColumn(name="question_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="question_tag_id", referencedColumnName = "id"))
    private List<QuestionTag> questionTags;

    @OneToMany(mappedBy = "question")
    List<UserQuestion> users;

    @OneToMany(mappedBy = "question")
    List<Choice> choices;

}

