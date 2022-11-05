package com.quizapp.user;

import java.util.List;

public interface UserService {

    CreateUserRequest createUser(UserCreationDto identifier);
    List<UserDto> getUsers();
}
