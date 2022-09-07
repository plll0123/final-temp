package com.example.demofinaltemp.exception;

import com.example.demofinaltemp.enums.UserErrorResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class UserException extends SuperException {

    private final UserErrorResult errorResult;

    private Map<Object, Object> rejectedValue;

    public void addValidation(String name, String value){
        rejectedValue.put(name, value);
    }
}
