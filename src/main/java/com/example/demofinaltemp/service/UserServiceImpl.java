package com.example.demofinaltemp.service;

import com.example.demofinaltemp.enums.UserErrorResult;
import com.example.demofinaltemp.exception.UserException;
import com.example.demofinaltemp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public void duplicateCheck(final String loginId) {
        if (userRepository.existsByLoginId(loginId)){
            throw new UserException(UserErrorResult.DUPLICATE_USER_ID);
        };
    }
}
