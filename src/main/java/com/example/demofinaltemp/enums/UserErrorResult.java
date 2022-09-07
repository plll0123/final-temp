package com.example.demofinaltemp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorResult implements SuperErrorResult{

    DUPLICATE_USER_ID(HttpStatus.CONFLICT, "Duplicate Login ID Register Request")
    ,;

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public String getName() {
        return this.name();
    }
}
