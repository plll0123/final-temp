package com.example.demofinaltemp.service;

import com.example.demofinaltemp.entity.User;
import com.example.demofinaltemp.enums.UserErrorResult;
import com.example.demofinaltemp.exception.UserException;
import com.example.demofinaltemp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(final String loginId) {
        User result = userRepository.findByLoginId(loginId);
        if (result != null){
            throw new UserException(UserErrorResult.DUPLICATE_USER_REGISTER);
        }
        return null;
    }
}
