package com.quizapp.question.service.impl;

import com.quizapp.choice.Choice;
import com.quizapp.choice.model.dto.ChoiceDto;
import com.quizapp.question.Question;
import com.quizapp.question.model.request.CreateQuestionRequest;
import com.quizapp.question.repository.QuestionRepository;
import com.quizapp.question.service.QuestionService;
import com.quizapp.questiontag.QuestionTag;
import com.quizapp.questiontag.QuestionTagRepository;
import com.quizapp.shared.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionTagRepository questionTagRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    @Override
    public GenericResponse createQuestion(CreateQuestionRequest request) {
        Question question = new Question();
        question.setLangCode(request.getLangCode());
        question.setQuestionText(request.getQuestionText());
        QuestionTag questionTag = questionTagRepository.getById(request.getQuestionTagId());
        question.setQuestionTags(Collections.singletonList(questionTag));
        prepareChoices(request.getChoices(), question);
        Long questionId = questionRepository.save(question).getId();
        return new GenericResponse("success", questionId);
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    private void prepareChoices(List<ChoiceDto> choiceRequestList, Question question) {
        for (ChoiceDto choiceRequest: choiceRequestList){
            Choice choiceEntity = new Choice();
            choiceEntity.setChoiceText(choiceRequest.getChoiceText());
            choiceEntity.setCorrect(choiceRequest.isCorrect());
            question.addChoice(choiceEntity);
        }
    }
}
