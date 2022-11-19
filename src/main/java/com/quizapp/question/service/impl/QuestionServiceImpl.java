package com.quizapp.question.service.impl;

import com.quizapp.question.Question;
import com.quizapp.question.model.request.CreateQuestionRequest;
import com.quizapp.question.service.QuestionService;
import com.quizapp.shared.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    @Override
    public GenericResponse createQuestion(CreateQuestionRequest request) {
        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setQuestionTags(request.getQuestionTagId());
        question.setChoices();
        return null;
    }
}
