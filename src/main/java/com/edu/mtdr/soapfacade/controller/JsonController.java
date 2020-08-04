package com.edu.mtdr.soapfacade.controller;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeArgumentException;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonReq;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.AddResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.DivideResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.MultiplyResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.SubtractResponse;
import com.edu.mtdr.soapfacade.service.SoapClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Калькулятор",
        description = "Сервис-фасад над http://www.dneonline.com/calculator.asmx для взаимодействия по REST JSON")
public class JsonController {
    private final SoapClient soapClient;

    @Autowired
    public JsonController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @PostMapping("/multiply")
    @ApiOperation("Операция умножения")
    public CalcJsonResponse multiply( @RequestBody CalcJsonReq req) {
        MultiplyResponse soapResponse = soapClient.getMultiplyResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getMultiplyResult());
    }

    @PostMapping("/add")
    @ApiOperation("Операция сложения")
    public CalcJsonResponse add(@RequestBody CalcJsonReq req) {
        AddResponse soapResponse = soapClient.getAdditionResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getAddResult());
    }

    @PostMapping("/divide")
    @ApiOperation("Операция деления")
    public CalcJsonResponse divide(@RequestBody CalcJsonReq req) {
        if (req.getB() == 0) {
            throw new SoapFacadeArgumentException("Делитель не может быть 0");
        }
        DivideResponse soapResponse = soapClient.getDivideResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getDivideResult());
    }

    @PostMapping("/subtract")
    @ApiOperation("Операция вычитания")
    public CalcJsonResponse subtract(@RequestBody CalcJsonReq req) {
        SubtractResponse soapResponse = soapClient.getSubtractResult(req.getA(), req.getB());
        return new CalcJsonResponse(soapResponse.getSubtractResult());
    }
}
