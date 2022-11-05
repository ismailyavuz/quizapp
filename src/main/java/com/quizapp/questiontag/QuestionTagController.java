package com.quizapp.questiontag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-tags")
@RequiredArgsConstructor
public class QuestionTagController {

    private final QuestionTagService questionTagService;

    @GetMapping
    public List<QuestionTagDto> getQuestionTags() {
        return questionTagService.getQuestionTags();
    }

    @PostMapping
    public QuestionTagDto createQuestionTag(@RequestBody CreateQuestionTagRequest questionTagDto) {
        return questionTagService.createQuestionTag(questionTagDto);
    }

}
