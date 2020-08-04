package com.edu.mtdr.soapfacade.controller;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeArgumentException;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonRequestMessage;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonResponseMessage;
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
    public CalcJsonResponseMessage multiply(@RequestBody CalcJsonRequestMessage req) {
        if (req.getA() == 0 || req.getB() == 0) {
            return new CalcJsonResponseMessage(0);
        }
        MultiplyResponse soapResponse = soapClient.getMultiplyResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getMultiplyResult());
    }

    @PostMapping("/add")
    @ApiOperation("Операция сложения")
    public CalcJsonResponseMessage add(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            return new CalcJsonResponseMessage(req.getA());
        }
        if (req.getA() == 0) {
            return new CalcJsonResponseMessage(req.getB());
        }
        AddResponse soapResponse = soapClient.getAdditionResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getAddResult());
    }

    @PostMapping("/divide")
    @ApiOperation("Операция деления")
    public CalcJsonResponseMessage divide(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            throw new SoapFacadeArgumentException("Делитель не может быть 0");
        }
        if (req.getB() == 1) {
            return new CalcJsonResponseMessage(req.getA());
        }
        DivideResponse soapResponse = soapClient.getDivideResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getDivideResult());
    }

    @PostMapping("/subtract")
    @ApiOperation("Операция вычитания")
    public CalcJsonResponseMessage subtract(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            return new CalcJsonResponseMessage(req.getA());
        }
        SubtractResponse soapResponse = soapClient.getSubtractResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getSubtractResult());
    }
}
