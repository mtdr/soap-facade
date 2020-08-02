package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

    public AddResponse getAdditionResult() {
        Addition additionReq = new Addition();
        Addition.Body.Add add = new Addition.Body.Add();
        add.setIntA("1");
        add.setIntB("1");
        Addition.Body body = new Addition.Body();
        body.setAdd(add);
        additionReq.setBody(body);

        log.info("Requesting addition res");

        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                        additionReq, new SoapActionCallback("http://tempuri.org/Add"));

        return response;
    }

    public MultiplyResponse getMultiplyResult(int a, int b) {
        Multiply multiplyReq = new Multiply();

        multiplyReq.setIntA(a);
        multiplyReq.setIntB(b);
        log.info("Requesting multiply res");

        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                        multiplyReq, new SoapActionCallback("http://tempuri.org/Multiply"));

        return response;
    }
}
