package com.quizapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> new UserDto(u.getId(), u.getIdentifier(), u.isEnabled())).collect(Collectors.toList());
    }

    @Override
    public User findByIdentifier(String identifier) {
        return userRepository.findByIdentifier(identifier);
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        User user = new User();
        user.setIdentifier(request.getIdentifier());
        user = userRepository.save(user);
        return new CreateUserResponse(user.getId(), user.getIdentifier());
    }
}
