package com.quizapp.question.model.response;

import com.quizapp.choice.model.dto.ChoiceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestionResponse {
    private Long id;
    private String questionText;
    private List<ChoiceDto> choices = new ArrayList<>();
}
