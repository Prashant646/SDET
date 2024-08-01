package org.prashant.exceptions;

public class UIException extends RuntimeException {
    public UIException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
