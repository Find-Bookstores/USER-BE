package com.example.tamchack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Invalid TokenResponse")
public class InvalidTokenException extends RuntimeException{
}


