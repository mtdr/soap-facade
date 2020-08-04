package com.edu.mtdr.soapfacade.model.exceptions;

public class SoapFacadeResultException extends RuntimeException {
    public SoapFacadeResultException() {
    }

    public SoapFacadeResultException(String message) {
        super(message);
    }

    public SoapFacadeResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapFacadeResultException(Throwable cause) {
        super(cause);
    }

    public SoapFacadeResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
