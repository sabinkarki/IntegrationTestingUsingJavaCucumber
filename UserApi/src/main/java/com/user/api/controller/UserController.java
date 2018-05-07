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
@RequestMapping(value = "api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/users"})
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> postUsers(@ApiParam(value = "User", required = true) User user) {
        userService.addUser(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@ApiParam(value = "Id of User", required = true) @RequestParam("id") int id) {
        return new ResponseEntity<>(userService.removeUser(id), HttpStatus.NO_CONTENT);
    }

}
