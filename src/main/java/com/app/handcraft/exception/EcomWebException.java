package com.app.handcraft.exception;

public class EcomWebException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public EcomWebException() {
        super();
    }

    public EcomWebException(String message) {
        super(message);
        this.message = message;
    }

    public EcomWebException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public EcomWebException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EcomWebException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
