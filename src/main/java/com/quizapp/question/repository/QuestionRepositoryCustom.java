package com.quizapp.question.repository;

import com.quizapp.question.Question;

import java.util.Date;

public interface QuestionRepositoryCustom {
    Question getNextQuestion(String identifier, Long questionTagId, Date askAgainBeforeThisDate);
}
