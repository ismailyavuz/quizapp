package com.quizapp.userquestion;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserQuestionId implements Serializable {

    private static final long serialVersionUID = -6700230677849886978L;

    private Long userId;
    private Long questionId;
}
