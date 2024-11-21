package com.enigm.belajar_restapi.service.impl;

import com.enigm.belajar_restapi.dto.UserRequest;
import com.enigm.belajar_restapi.dto.UserRespond;
import com.enigm.belajar_restapi.entity.User;
import com.enigm.belajar_restapi.repository.UserRepository;
import com.enigm.belajar_restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserRespond> getAllUser() {
        List<UserRespond> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(convert(user)));
        return users;
    }

    @Override
    public UserRespond createUser(UserRequest userBookRequest) {
        User user = User.builder()
                .name(userBookRequest.getName())
                .build();
        userRepository.saveAndFlush(user);
        return convert(user);
    }

    @Override
    public UserRespond updateUser(UUID uuid, UserRequest userBookRequest) {
        User updatedUser = userRepository.findById(uuid).get();
        updatedUser.setName(userBookRequest.getName());
        userRepository.saveAndFlush(updatedUser);
        return convert(updatedUser);
    }

    @Override
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public UserRespond convert(User user) {
        UserRespond userRespond = UserRespond.builder()
                .name(user.getName())
                .build();

        return userRespond;
    }
}
