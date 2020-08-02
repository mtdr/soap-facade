package com.edu.mtdr.soapfacade.controller;

import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonReq;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonResponse;
import com.edu.mtdr.soapfacade.service.SoapClient;
import com.edu.mtdr.soapfacade.wsdl.AddResponse;
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
    CalcJsonResponse multiply(@RequestBody CalcJsonReq req) {
        MultiplyResponse soapResponse = soapClient.getMultiplyResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getMultiplyResult());
    }

    @PostMapping("/addition")
    CalcJsonResponse addition(@RequestBody CalcJsonReq req) {
        AddResponse soapResponse = soapClient.getAdditionResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getAddResult());
    }
}
