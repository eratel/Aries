package com.abhsy.aries.exception;

public class AriesException extends RuntimeException {
    private static final long serialVersionUID = 7975167663357170655L;

    public AriesException() {
        super();
    }

    public AriesException(String message) {
        super(message);
    }

    public AriesException(String message, Throwable cause) {
        super(message, cause);
    }

    public AriesException(Throwable cause) {
        super(cause);
    }
}