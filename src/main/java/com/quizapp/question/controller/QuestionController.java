package com.quizapp.question.controller;

import com.quizapp.question.model.request.CreateQuestionRequest;
import com.quizapp.question.service.QuestionService;
import com.quizapp.shared.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping(value = "/questions")
    public GenericResponse createQuestion(@RequestBody CreateQuestionRequest request){
       return questionService.createQuestion(request);
    }

}
