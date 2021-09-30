package com.app.handcraft.exception;

public class EcomServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public EcomServiceException() {
        super();
    }

    public EcomServiceException(String message) {
        super(message);
        this.message = message;
    }

    public EcomServiceException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public EcomServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EcomServiceException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
