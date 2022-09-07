package com.example.demofinaltemp.config;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class HttpStatusConst {

    public static final ResponseEntity<HttpStatus> RESPONSE_CREATED = ResponseEntity.status(HttpStatus.CREATED).build();
}
