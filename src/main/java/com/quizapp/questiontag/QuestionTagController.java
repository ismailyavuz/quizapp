package com.quizapp.questiontag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/question-tags")
@RequiredArgsConstructor
public class QuestionTagController {

    private final QuestionTagService questionTagService;

    @GetMapping
    public List<QuestionTagDto> getQuestionTags() {
        return questionTagService.getQuestionTags();
    }

    @PostMapping("/create")
    public QuestionTagDto createQuestionTag(@RequestBody CreateQuestionTagRequest questionTagDto) {
        return questionTagService.createQuestionTag(questionTagDto);
    }

}