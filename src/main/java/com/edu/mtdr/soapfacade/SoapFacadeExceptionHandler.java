package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeArgumentException;
import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeResultException;
import com.edu.mtdr.soapfacade.model.jsonMsgs.ErrorResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SoapFacadeExceptionHandler {

    /**
     * Handling of exceptions during request argument checking
     * @param e {@link SoapFacadeArgumentException} arguments exception
     * @return message with error
     */
    @ResponseBody
    @ExceptionHandler(SoapFacadeArgumentException.class)
    public ErrorResponseMessage handleArgumentException(SoapFacadeArgumentException e) {
        return new ErrorResponseMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handling of exceptions in result of operations
     * @param e {@link SoapFacadeResultException} result exception
     * @return message with error
     */
    @ResponseBody
    @ExceptionHandler(SoapFacadeResultException.class)
    public ErrorResponseMessage handleResultException(SoapFacadeResultException e) {
        return new ErrorResponseMessage(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handling of incorrect request format exception
     * @return message with error
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponseMessage handleResultException() {
        return new ErrorResponseMessage("Error! Message must contain two integer arguments 'a' and 'b'",
                HttpStatus.BAD_REQUEST);
    }
}
