package com.quizapp.question.controller;

import com.quizapp.question.controller.endpoint.QuestionControllerEndpoint;
import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(value = QuestionControllerEndpoint.GET_QUESTION_BY_QUESTION_TAG_ID)
    public QuestionResponse getQuestionByQuestionTagId(@PathVariable Long questionTagId,
                                                       @RequestHeader Long userId) {
        return questionService.getQuestionByQuestionTagId(questionTagId, userId);
    }
}
