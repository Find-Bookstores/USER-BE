package com.example.tamchack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.GONE, reason = "Expired Token")
public class ExpiredTokenException extends RuntimeException{
}
