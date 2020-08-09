package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.model.soapMsgs.*;
import com.edu.mtdr.soapfacade.util.SoapExchangeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Calculator service
 */
@Service
public class CalculatorService implements ICalculatorService {
    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    /**
     * SOAP message exchange utility
     */
    private SoapExchangeUtil soapExchangeUtil;

    /**
     * @param a addend
     * @param b addend
     * @return sum in SOAP response {@link AddResponse}
     */
    public AddResponse getAdditionResult(int a, int b) {
        Add additionReq = new Add();
        additionReq.setIntA(a);
        additionReq.setIntB(b);

        LOGGER.info("Requesting addition of " + a + " " + b + " result");

        return (AddResponse) soapExchangeUtil.sendSoapRequest(additionReq, "Add");
    }

    /**
     * @param a multiplier
     * @param b multiplier
     * @return product of numbers in SOAP response {@link MultiplyResponse}
     */
    public MultiplyResponse getMultiplyResult(int a, int b) {
        Multiply multiplyReq = new Multiply();

        multiplyReq.setIntA(a);
        multiplyReq.setIntB(b);
        LOGGER.info("Requesting multiplication of " + a + " " + b + " result");

        return (MultiplyResponse) soapExchangeUtil.sendSoapRequest(multiplyReq, "Multiply");
    }

    /**
     * @param a dividend
     * @param b divisor
     * @return ratio in SOAP response {@link DivideResponse}
     */
    public DivideResponse getDivideResult(int a, int b) {
        Divide divideReq = new Divide();

        divideReq.setIntA(a);
        divideReq.setIntB(b);
        LOGGER.info("Requesting division of " + a + " " + b + " result");

        return (DivideResponse) soapExchangeUtil.sendSoapRequest(divideReq, "Divide");
    }

    /**
     * @param a depreciate
     * @param b subtrahend
     * @return difference in SOAP response {@link SubtractResponse}
     */
    public SubtractResponse getSubtractResult(int a, int b) {
        Subtract subtractReq = new Subtract();

        subtractReq.setIntA(a);
        subtractReq.setIntB(b);
        LOGGER.info("Requesting subtraction of " + a + " " + b + " result");

        return (SubtractResponse) soapExchangeUtil.sendSoapRequest(subtractReq, "Subtract");
    }

    @Autowired
    public void setSoapSenderUtil(SoapExchangeUtil soapExchangeUtil) {
        this.soapExchangeUtil = soapExchangeUtil;
    }
}
