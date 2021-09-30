package com.app.handcraft.exception;

public class DataNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public DataNotFoundException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
