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
     * Отлавливание исключений при проверке аргументов запросов
     * @param e {@link SoapFacadeResultException} исключение аргументов
     * @return сообщение об ошибке
     */
    @ResponseBody
    @ExceptionHandler(SoapFacadeArgumentException.class)
    public ErrorResponseMessage handleArgumentException(SoapFacadeArgumentException e) {
        return new ErrorResponseMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Отлавливание исключений по результатам вычислений
     * @param e {@link SoapFacadeResultException} исключение результата
     * @return сообщение об ошибке
     */
    @ResponseBody
    @ExceptionHandler(SoapFacadeResultException.class)
    public ErrorResponseMessage handleResultException(SoapFacadeResultException e) {
        return new ErrorResponseMessage(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Отлавливание исключений о некорректности формата запроса
     * @return сообщение об ошибке
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponseMessage handleResultException() {
        return new ErrorResponseMessage("Ошибка запроса! Сообщение должно содержать два целочисленных аргумента a и b",
                HttpStatus.BAD_REQUEST);
    }
}
