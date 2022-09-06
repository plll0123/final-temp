package com.example.demofinaltemp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorResult {

    DUPLICATE_USER_REGISTER(HttpStatus.BAD_REQUEST, "Duplicate User Register Request")
    ,;

    private final HttpStatus status;
    private final String message;
}
