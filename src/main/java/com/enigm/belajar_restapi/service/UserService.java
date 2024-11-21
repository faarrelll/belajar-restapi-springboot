package com.enigm.belajar_restapi.service;

import com.enigm.belajar_restapi.dto.BookRequest;
import com.enigm.belajar_restapi.dto.BookRespond;
import com.enigm.belajar_restapi.dto.UserRequest;
import com.enigm.belajar_restapi.dto.UserRespond;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserRespond> getAllUser();
    UserRespond createUser(UserRequest userBookRequest);
    UserRespond updateUser(UUID uuid, UserRequest userBookRequest);
    void deleteUser(UUID uuid);

}
