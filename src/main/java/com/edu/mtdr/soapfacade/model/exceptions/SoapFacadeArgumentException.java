package com.edu.mtdr.soapfacade.model.exceptions;

public class SoapFacadeArgumentException extends RuntimeException {

    public SoapFacadeArgumentException(String message) {
        super(message);
    }

    public SoapFacadeArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapFacadeArgumentException(Throwable cause) {
        super(cause);
    }

    public SoapFacadeArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SoapFacadeArgumentException() {
    }
}
