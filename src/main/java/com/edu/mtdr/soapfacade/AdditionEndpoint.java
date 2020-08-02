package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.wsdl.Addition;
import com.edu.mtdr.soapfacade.wsdl.EnvelopeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AdditionEndpoint {

    @PayloadRoot(namespace = "localhost", localPart = "getCountryRequest")
    @ResponsePayload
    public EnvelopeResponse getAdditionResult(@RequestPayload Addition request) {
        EnvelopeResponse.Body.AddResponse response = new EnvelopeResponse.Body.AddResponse();
        response.setAddResult("");
        EnvelopeResponse envelopeResponse = new EnvelopeResponse();
        EnvelopeResponse.Body envelopeResponseBody = new EnvelopeResponse.Body();
        envelopeResponseBody.setAddResponse(response);
        envelopeResponse.setBody(envelopeResponseBody);

        return envelopeResponse;
    }
}
