package com.example.demofinaltemp.service;

import com.example.demofinaltemp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
public class UserJoinRequest {

    private final String loginId;
    private final String password;
    private final String name;

}
