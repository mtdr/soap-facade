package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.jsonMsgs.MultiplyJsonReq;
import com.edu.mtdr.soapfacade.jsonMsgs.MultiplyJsonResponse;
import com.edu.mtdr.soapfacade.wsdl.MultiplyResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Калькулятор")
public class JsonController {
    private final SoapClient soapClient;

    @Autowired
    public JsonController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @PostMapping("/multiply")
    MultiplyJsonResponse multiply(@RequestBody MultiplyJsonReq req) {
        MultiplyResponse soapResponse = soapClient.getMultiplyResult(req.getA(), req.getB());
        return new MultiplyJsonResponse(soapResponse.getMultiplyResult());
    }
}
