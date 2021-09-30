package com.app.handcraft.exception;

public class EcomDataAccessException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public EcomDataAccessException() {
        super();
    }

    public EcomDataAccessException(String message) {
        super(message);
        this.message = message;
    }

    public EcomDataAccessException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public EcomDataAccessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EcomDataAccessException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
