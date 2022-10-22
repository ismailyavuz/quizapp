package com.quizapp.questiontag;

import java.util.List;

public interface QuestionTagService {
    List<QuestionTagDto> getQuestionTags();

    QuestionTagDto createQuestionTag(CreateQuestionTagRequest name);
}
