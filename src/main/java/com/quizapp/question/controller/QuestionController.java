package com.quizapp.question.controller;

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

    @GetMapping(value = "/question-tags/{questionTagId}/questions")
    public QuestionResponse getQuestionByQuestionTagId(@PathVariable Long questionTagId,
                                                       @RequestHeader String identifier) {
        return questionService.getQuestionByQuestionTagId(questionTagId, identifier);
    }
}
