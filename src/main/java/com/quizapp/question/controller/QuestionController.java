package com.quizapp.question.controller;

import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.question.service.QuestionService;
import com.quizapp.shared.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(value = "/question-tags/{questionTagId}/questions")
    public QuestionResponse getQuestionByQuestionTagId(@PathVariable Long questionTagId,
                                                       @RequestHeader String identifier) {
        return questionService.getQuestionByQuestionTagId(questionTagId, identifier);
    }

    @PostMapping(value = "/questions/{questionId}/result/{isCorrect}")
    public GenericResponse saveUserAnswerResult(@PathVariable Long questionId,
                                                @PathVariable Boolean isCorrect,
                                                @RequestHeader String identifier) {
        return questionService.saveUserAnswerResult(questionId, isCorrect, identifier);
    }
}
