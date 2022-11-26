package com.quizapp.userquestion;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserQuestionId implements Serializable {

    private static final long serialVersionUID = -6700230677849886978L;

    private Long userId;
    private Long questionId;
}
