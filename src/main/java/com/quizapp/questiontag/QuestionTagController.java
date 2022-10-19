package com.quizapp.questiontag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionTagController {

    private final QuestionTagService questionTagService;

    @GetMapping(value = "/question-tags")
    public List<QuestionTagResponse> getQuestionTags() {
        return questionTagService.getQuestionTags();
    }

}
