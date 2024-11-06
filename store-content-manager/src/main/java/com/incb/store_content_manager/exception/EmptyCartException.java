package com.incb.store_content_manager.exception;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
    }

    public EmptyCartException(String message) {
        super(message);
    }

    public EmptyCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyCartException(Throwable cause) {
        super(cause);
    }

    public EmptyCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
