package com.edu.mtdr.soapfacade.controller;

import com.edu.mtdr.soapfacade.model.jsonMsgs.multiply.MultiplyJsonReq;
import com.edu.mtdr.soapfacade.model.jsonMsgs.multiply.MultiplyJsonResponse;
import com.edu.mtdr.soapfacade.service.SoapClient;
import com.edu.mtdr.soapfacade.wsdl.MultiplyResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Калькулятор",
        description = "Сервис-фасад над http://www.dneonline.com/calculator.asmx для взаимодействия по REST JSON")
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
