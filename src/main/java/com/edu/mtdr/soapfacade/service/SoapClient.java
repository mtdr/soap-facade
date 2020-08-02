package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

    public AddResponse getAdditionResult(int a, int b) {
        Addition additionReq = new Addition();
        Addition.Body.Add add = new Addition.Body.Add();
        add.setIntA(String.valueOf(a));
        add.setIntB(String.valueOf(b));
        Addition.Body body = new Addition.Body();
        body.setAdd(add);
        additionReq.setBody(body);

        log.info("Requesting addition res");

        return (AddResponse) sendSoapRequest(additionReq, "Add");
    }

    public MultiplyResponse getMultiplyResult(int a, int b) {
        Multiply multiplyReq = new Multiply();

        multiplyReq.setIntA(a);
        multiplyReq.setIntB(b);
        log.info("Requesting multiply res");

        return (MultiplyResponse) sendSoapRequest(multiplyReq, "Multiply");
    }

    public DivideResponse getDivideResult(int a, int b) {
        Divide divideReq = new Divide();

        divideReq.setIntA(a);
        divideReq.setIntB(b);
        log.info("Requesting divide res");

        return (DivideResponse) sendSoapRequest(divideReq, "Divide");
    }

    public SubtractResponse getSubtractResult(int a, int b) {
        Subtract subtractReq = new Subtract();

        subtractReq.setIntA(a);
        subtractReq.setIntB(b);
        log.info("Requesting subtract res");

        return (SubtractResponse) sendSoapRequest(subtractReq, "Subtract");
    }

    private Object sendSoapRequest(Object reqObj, String req) {
        return getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                        reqObj, new SoapActionCallback("http://tempuri.org/" + req));
    }
}
