package com.edu.mtdr.soapfacade.controller;

import com.edu.mtdr.soapfacade.model.exceptions.SoapFacadeArgumentException;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonRequestMessage;
import com.edu.mtdr.soapfacade.model.jsonMsgs.CalcJsonResponseMessage;
import com.edu.mtdr.soapfacade.model.soapMsgs.AddResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.DivideResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.MultiplyResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.SubtractResponse;
import com.edu.mtdr.soapfacade.service.ICalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Calculator",
        description = "Adapter for http://www.dneonline.com/calculator.asmx to exchange by REST JSON")
public class JsonController {
    private final ICalculatorService soapClientService;

    @Autowired
    public JsonController(ICalculatorService soapClientService) {
        this.soapClientService = soapClientService;
    }

    @PostMapping("/multiply")
    @ApiOperation("Multiplication")
    public CalcJsonResponseMessage multiply(@RequestBody CalcJsonRequestMessage req) {
        if (req.getA() == 0 || req.getB() == 0) {
            return new CalcJsonResponseMessage(0);
        }
        MultiplyResponse soapResponse = soapClientService.getMultiplyResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getMultiplyResult());
    }

    @PostMapping("/add")
    @ApiOperation("Addition")
    public CalcJsonResponseMessage add(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            return new CalcJsonResponseMessage(req.getA());
        }
        if (req.getA() == 0) {
            return new CalcJsonResponseMessage(req.getB());
        }
        AddResponse soapResponse = soapClientService.getAdditionResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getAddResult());
    }

    @PostMapping("/divide")
    @ApiOperation("Division")
    public CalcJsonResponseMessage divide(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            throw new SoapFacadeArgumentException("Делитель не может быть 0");
        }
        if (req.getB() == 1) {
            return new CalcJsonResponseMessage(req.getA());
        }
        DivideResponse soapResponse = soapClientService.getDivideResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getDivideResult());
    }

    @PostMapping("/subtract")
    @ApiOperation("Subtraction")
    public CalcJsonResponseMessage subtract(@RequestBody CalcJsonRequestMessage req) {
        if (req.getB() == 0) {
            return new CalcJsonResponseMessage(req.getA());
        }
        SubtractResponse soapResponse = soapClientService.getSubtractResult(req.getA(), req.getB());
        return new CalcJsonResponseMessage(soapResponse.getSubtractResult());
    }
}
