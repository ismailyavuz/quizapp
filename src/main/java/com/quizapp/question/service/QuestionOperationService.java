package com.quizapp.question.service;

import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.shared.response.GenericResponse;

public interface QuestionOperationService {

    QuestionResponse getQuestionByQuestionTagId(Long questionTagId, String identifier);

    GenericResponse saveUserAnswerResult(Long questionId, Boolean isCorrect, String identifier);
}
