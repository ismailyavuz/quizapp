package com.quizapp.question.converter;

import com.quizapp.choice.model.dto.ChoiceDto;
import com.quizapp.question.Question;
import com.quizapp.question.model.response.QuestionResponse;
import org.springframework.stereotype.Component;

@Component
public class QuestionToQuestionResponseConverter {

    public QuestionResponse convert(Question question) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId(question.getId());
        questionResponse.setQuestionText(question.getQuestionText());
        prepareChoices(question, questionResponse);
        return questionResponse;
    }

    private void prepareChoices(Question question, QuestionResponse questionResponse) {
        question.getChoices()
                .forEach(choice -> {
                    ChoiceDto choiceDto = new ChoiceDto();
                    choiceDto.setId(choice.getId());
                    choiceDto.setChoiceText(choice.getChoiceText());
                    choiceDto.setCorrect(choice.isCorrect());
                    questionResponse.getChoices().add(choiceDto);
                });
    }
}
