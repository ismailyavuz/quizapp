package com.quizapp.choice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceDto {
    private Long id;
    private String choiceText;
    private boolean correct;
}
