package com.quizapp.user;

import java.util.List;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest identifier);

    List<UserDto> getUsers();

}
