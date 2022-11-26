package com.quizapp.question.service.impl;

import com.quizapp.question.Question;
import com.quizapp.question.converter.QuestionToQuestionResponseConverter;
import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.question.repository.QuestionRepository;
import com.quizapp.question.repository.UserQuestionRepository;
import com.quizapp.question.service.QuestionOperationService;
import com.quizapp.shared.response.GenericResponse;
import com.quizapp.user.User;
import com.quizapp.user.UserService;
import com.quizapp.userquestion.UserQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class QuestionOperationServiceImpl implements QuestionOperationService {

    private final QuestionRepository questionRepository;
    private final UserService userService;
    private final UserQuestionRepository userQuestionRepository;
    private final QuestionToQuestionResponseConverter questionToQuestionResponseConverter;

    @Override
    public QuestionResponse getQuestionByQuestionTagId(Long questionTagId, String identifier) {
        Question question = questionRepository.getNextQuestion(identifier, questionTagId, new Date());
        return questionToQuestionResponseConverter.convert(question);
    }

    @Override
    public GenericResponse saveUserAnswerResult(Long questionId, Boolean isCorrect, String identifier) {
        User user = userService.findByIdentifier(identifier);
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setUser(user);
        Question question = new Question();
        question.setId(questionId);
        userQuestion.setQuestion(question);
        userQuestion.setCorrect(isCorrect);
        userQuestionRepository.save(userQuestion);
        return new GenericResponse("success");
    }
}
