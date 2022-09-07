package com.example.demofinaltemp.controller;

import com.example.demofinaltemp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Constraint;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/valid-id")
    public ResponseEntity<HttpStatus> duplicatedCheck(@RequestBody final String loginId){
        userService.duplicateCheck(loginId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
