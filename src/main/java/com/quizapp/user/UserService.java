package com.quizapp.user;

import java.util.List;

public interface UserService {

    UserCreationDto createUser(CreateUserRequest identifier);
    List<UserDto> getUsers();
}
