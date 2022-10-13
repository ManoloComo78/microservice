package com.manolovizzini.demo.microservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public class NotFoundException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(NotFoundException.class);

    private final HttpStatus statusCode;

    public NotFoundException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        logger.error(message);
    }

    public NotFoundException(String message) {
        super(message);
        this.statusCode = HttpStatus.NOT_FOUND;
        logger.error(message);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
