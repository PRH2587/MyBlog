package com.bomb.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 793881703856258755L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable e) {
        super(e);
    }

    public ServiceException(String message, Throwable e) {
        super(message, e);
    }

}
