package com.quizapp.shared.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class GenericResponse implements Serializable {
    private String message;
}
