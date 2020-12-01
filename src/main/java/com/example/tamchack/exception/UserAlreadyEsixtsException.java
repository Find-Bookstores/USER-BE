package com.example.tamchack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "UserAlreadyEsixtsException")
public class UserAlreadyEsixtsException extends RuntimeException{
}
