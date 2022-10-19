package com.quizapp.question.service;

import com.quizapp.question.model.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse getQuestionByQuestionTagId(Long questionTagId, String identifier);
}
