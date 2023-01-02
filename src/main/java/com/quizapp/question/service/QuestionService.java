package com.quizapp.question.service;

import com.quizapp.question.Question;
import com.quizapp.question.model.request.CreateQuestionRequest;
import com.quizapp.shared.response.GenericResponse;

public interface QuestionService {
    GenericResponse createQuestion(CreateQuestionRequest request);

    Question findById(long id);
}
