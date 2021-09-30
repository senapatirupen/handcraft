package com.app.handcraft.exception;

public class EcomApplicationException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;
    private String id;

    public EcomApplicationException() {
        super();
    }

    public EcomApplicationException(String message) {
        super(message);
        this.message = message;
    }

    public EcomApplicationException(String message, String id) {
        super(message);
        this.message = message;
        this.id = id;
    }

    public EcomApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public EcomApplicationException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

}
