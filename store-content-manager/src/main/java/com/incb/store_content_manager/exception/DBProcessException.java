package com.incb.store_content_manager.exception;

public class DBProcessException extends RuntimeException {
    public DBProcessException(Throwable cause) {
        super(cause);
    }

    public DBProcessException() {
    }

    public DBProcessException(String message) {
        super(message);
    }

    public DBProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
