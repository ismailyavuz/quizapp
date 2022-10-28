package com.quizapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user/create")
    public UserCreationDto createUser(@RequestBody CreateUserRequest userCreationDto){
        return userService.createUser(userCreationDto);
    }


}
