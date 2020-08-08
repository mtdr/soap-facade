package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.model.soapMsgs.*;
import com.edu.mtdr.soapfacade.util.SoapSenderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис калькулятора
 */
@Service
public class CalculatorService implements ICalculatorService {
    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    /**
     * Утилита для отправки и приема запросов от SOAP-сервера (сервиса калькулятора)
     */
    private SoapSenderUtil soapSenderUtil;

    /**
     * @param a слагаемое
     * @param b слагаемое
     * @return результат сложения - сумма - в объекте SOAP-ответа
     */
    public AddResponse getAdditionResult(int a, int b) {
        Add additionReq = new Add();
        additionReq.setIntA(a);
        additionReq.setIntB(b);

        LOGGER.info("Requesting addition res");

        return (AddResponse) soapSenderUtil.sendSoapRequest(additionReq, "Add");
    }

    /**
     * @param a множитель
     * @param b множитель
     * @return результат умножения - произведение - в объекте SOAP-ответа {@link MultiplyResponse}
     */
    public MultiplyResponse getMultiplyResult(int a, int b) {
        Multiply multiplyReq = new Multiply();

        multiplyReq.setIntA(a);
        multiplyReq.setIntB(b);
        LOGGER.info("Requesting multiply res");

        return (MultiplyResponse) soapSenderUtil.sendSoapRequest(multiplyReq, "Multiply");
    }

    /**
     * @param a делимое
     * @param b делитель
     * @return результат деления - частное - в объекте SOAP-ответа {@link DivideResponse}
     */
    public DivideResponse getDivideResult(int a, int b) {
        Divide divideReq = new Divide();

        divideReq.setIntA(a);
        divideReq.setIntB(b);
        LOGGER.info("Requesting divide res");

        return (DivideResponse) soapSenderUtil.sendSoapRequest(divideReq, "Divide");
    }

    /**
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return результат вычитания - разность - в объекте SOAP-ответа {@link SubtractResponse}
     */
    public SubtractResponse getSubtractResult(int a, int b) {
        Subtract subtractReq = new Subtract();

        subtractReq.setIntA(a);
        subtractReq.setIntB(b);
        LOGGER.info("Requesting subtract res");

        return (SubtractResponse) soapSenderUtil.sendSoapRequest(subtractReq, "Subtract");
    }

    @Autowired
    public void setSoapSenderUtil(SoapSenderUtil soapSenderUtil) {
        this.soapSenderUtil = soapSenderUtil;
    }
}
