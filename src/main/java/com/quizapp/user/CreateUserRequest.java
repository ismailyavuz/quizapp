package com.quizapp.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    private Long id;
    private String identifier;
}
