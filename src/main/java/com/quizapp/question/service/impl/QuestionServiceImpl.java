package com.quizapp.question.service.impl;

import com.quizapp.question.Question;
import com.quizapp.question.converter.QuestionToQuestionResponseConverter;
import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.question.repository.QuestionRepository;
import com.quizapp.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionResponse getQuestionByQuestionTagId(Long questionTagId, String identifier) {
        Question question = questionRepository.getNextQuestion(identifier, questionTagId, new Date());
        QuestionToQuestionResponseConverter converter = new QuestionToQuestionResponseConverter();
        return converter.convert(question);
    }
}
