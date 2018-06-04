package com.user.api.controller;

import com.user.api.domain.User;
import com.user.api.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sabin on 5/6/2018.
 */


@RestController
@RequestMapping(value = "api/v1/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/users"})
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = {"/usersExceptDefault"})
    public ResponseEntity<?> getUsersExceptDefault() {
        List<User> users = this.userService.getUsersExceptDefault();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> postUsers(@ApiParam(value = "User", required = true) @RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUserExceptDefaultData() {
        return new ResponseEntity<>(userService.removeUserExceptDefaultData(), HttpStatus.NO_CONTENT);
    }

}
