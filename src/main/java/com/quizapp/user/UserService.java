package com.quizapp.user;

import java.util.List;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest request);

    List<UserDto> getUsers();

    User findByIdentifier(String identifier);
}
