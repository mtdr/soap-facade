package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeResultException;
import com.edu.mtdr.soapfacade.model.soapMsgs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Клиент для отправки и приема запросов от SOAP-сервера (сервиса калькулятора)
 */
public class SoapClient extends WebServiceGatewaySupport {
    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);

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

        return (AddResponse) sendSoapRequest(additionReq, "Add");
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

        return (MultiplyResponse) sendSoapRequest(multiplyReq, "Multiply");
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

        return (DivideResponse) sendSoapRequest(divideReq, "Divide");
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

        return (SubtractResponse) sendSoapRequest(subtractReq, "Subtract");
    }

    /**
     * @param reqObj Объект запроса
     * @param req    Адрес запроса
     * @return Ответ SOAP-сервера
     */
    private Object sendSoapRequest(Object reqObj, String req) {
        try {
            return getWebServiceTemplate()
                    .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                            reqObj, new SoapActionCallback("http://tempuri.org/" + req));
        } catch (SoapFaultClientException e) {
            throw new SoapFacadeResultException(e.getCause());
        }
    }
}
