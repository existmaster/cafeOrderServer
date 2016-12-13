package com.narae.cafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by existmaster on 2016. 12. 4..
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class OrderNotProcessException extends RuntimeException {
    public OrderNotProcessException(String userId) {
        super("order not process '" + userId + "'.");
    }
}
