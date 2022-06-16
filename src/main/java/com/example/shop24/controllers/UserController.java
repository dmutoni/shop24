package com.example.shop24.controllers;

import com.example.shop24.dtos.ResponseDto;
import com.example.shop24.models.User;
import com.example.shop24.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@RestController("/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched users", users), HttpStatus.OK);
    }

    @GetMapping("/:id")
    public ResponseEntity<ResponseDto> getById(@PathVariable UUID id) throws Exception {
        User user = userService.findById(id);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully fetched user", user), HttpStatus.OK);
    }

    @GetMapping("/:id")
    public ResponseEntity<ResponseDto> getClosestCargoCompanies(@PathVariable UUID id) throws Exception {
        User user = userService.findById(id);
        return new ResponseEntity<>(new ResponseDto(HttpStatus.OK, "Successfully near cargo companies in 3 km user", user), HttpStatus.OK);
    }
}
