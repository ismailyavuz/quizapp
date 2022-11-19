package com.quizapp.question.model.request;

import com.quizapp.choice.model.dto.ChoiceDto;
import com.quizapp.question.model.enums.LangCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateQuestionRequest {
    private LangCodeEnum langCode;
    private String questionText;
    private Long questionTagId;
    private List<ChoiceDto> choices;
}
