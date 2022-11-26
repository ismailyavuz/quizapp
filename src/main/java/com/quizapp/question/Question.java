package com.quizapp.question;

import com.quizapp.choice.Choice;
import com.quizapp.question.model.enums.LangCodeEnum;
import com.quizapp.questiontag.QuestionTag;
import com.quizapp.shared.entities.BaseEntity;
import com.quizapp.userquestion.UserQuestion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Question extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private LangCodeEnum langCode;
    private String questionText;

    @ManyToMany
    @JoinTable(name="question_question_tag",
    joinColumns = @JoinColumn(name="question_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="question_tag_id", referencedColumnName = "id"))
    private List<QuestionTag> questionTags;

    @OneToMany(mappedBy = "question")
    List<UserQuestion> users;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    List<Choice> choices = new ArrayList<>();

    public void addChoice(Choice choice) {
        choice.setQuestion(this);
        choices.add(choice);
    }

}

