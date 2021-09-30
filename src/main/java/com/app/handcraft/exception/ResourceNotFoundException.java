package com.app.handcraft.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ResourceNotFoundException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
