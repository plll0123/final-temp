package com.example.demofinaltemp.exception;

import com.example.demofinaltemp.enums.UserErrorResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException{

    private final UserErrorResult errorResult;

}
