package com.quizapp.user;

import java.util.List;

public interface UserService {

    UserCreationDto createUser(CreateUserResponse identifier);
    List<UserDto> getUsers();
}
