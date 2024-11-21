package com.enigm.belajar_restapi.controller;


import com.enigm.belajar_restapi.constant.Constant;
import com.enigm.belajar_restapi.dto.UserRequest;
import com.enigm.belajar_restapi.dto.UserRespond;
import com.enigm.belajar_restapi.service.UserService;
import com.enigm.belajar_restapi.utils.RespondUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(Constant.USER_API)
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<UserRespond> users = userService.getAllUser();
        return RespondUtils.buildResponse(HttpStatus.OK,"Succes Get User Data" ,users);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequest user) {
        UserRespond newUser = userService.createUser(user);
        return RespondUtils.buildResponse(HttpStatus.CREATED,"Succes Add User Data" ,newUser);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody UserRequest user) {
        UserRespond updatedUser = userService.updateUser(UUID.fromString(id), user);
        return RespondUtils.buildResponse(HttpStatus.OK,"Succes Update User Data" ,updatedUser);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(UUID.fromString(id));
        return RespondUtils.buildResponse(HttpStatus.OK,"Succes Delete User Data" ,null);
    }
}
