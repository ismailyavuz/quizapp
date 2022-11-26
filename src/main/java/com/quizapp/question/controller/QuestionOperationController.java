package com.quizapp.question.controller;

import com.quizapp.question.model.response.QuestionResponse;
import com.quizapp.question.service.QuestionOperationService;
import com.quizapp.shared.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuestionOperationController {

    private final QuestionOperationService questionOperationService;

    @GetMapping(value = "/question-tags/{questionTagId}/questions")
    public QuestionResponse getQuestionByQuestionTagId(@PathVariable Long questionTagId,
                                                       @RequestHeader String identifier) {
        return questionOperationService.getQuestionByQuestionTagId(questionTagId, identifier);
    }

    @PostMapping(value = "/questions/{questionId}/result/{isCorrect}")
    public GenericResponse saveUserAnswerResult(@PathVariable Long questionId,
                                                @PathVariable Boolean isCorrect,
                                                @RequestHeader String identifier) {
        return questionOperationService.saveUserAnswerResult(questionId, isCorrect, identifier);
    }
}
