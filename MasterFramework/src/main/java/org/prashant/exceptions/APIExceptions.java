package org.prashant.exceptions;

public class APIExceptions extends RuntimeException {

    public APIExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
