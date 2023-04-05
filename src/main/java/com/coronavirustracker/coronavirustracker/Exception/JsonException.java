package com.coronavirustracker.coronavirustracker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class JsonException extends RuntimeException{
    public JsonException(String s) {
        super(s);
    }
}
