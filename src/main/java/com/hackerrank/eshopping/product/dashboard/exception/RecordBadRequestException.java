package com.hackerrank.eshopping.product.dashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecordBadRequestException extends Exception {

    private static final long serialVersionUID = 1L;

    public RecordBadRequestException(String message) {
        super(message);
    }
}
