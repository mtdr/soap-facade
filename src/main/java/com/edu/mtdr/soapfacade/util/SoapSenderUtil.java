package com.edu.mtdr.soapfacade.util;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeResultException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Утилита для низкоуровневого общения с SOAP-сервером
 */
public class SoapSenderUtil extends WebServiceGatewaySupport {
    /**
     * @param reqObj Объект запроса
     * @param req    Адрес запроса
     * @return Ответ SOAP-сервера
     */
    public Object sendSoapRequest(Object reqObj, String req) {
        try {
            return getWebServiceTemplate()
                    .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                            reqObj, new SoapActionCallback("http://tempuri.org/" + req));
        } catch (SoapFaultClientException e) {
            throw new SoapFacadeResultException(e.getCause());
        }
    }
}
