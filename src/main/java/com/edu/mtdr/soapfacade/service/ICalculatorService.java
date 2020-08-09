package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.model.soapMsgs.AddResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.DivideResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.MultiplyResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.SubtractResponse;

/**
 * Calculator service interface
 */
public interface ICalculatorService {
    /**
     * @param a addend
     * @param b addend
     * @return sum in SOAP response {@link AddResponse}
     */
    AddResponse getAdditionResult(int a, int b);

    /**
     * @param a multiplier
     * @param b multiplier
     * @return product of numbers in SOAP response {@link MultiplyResponse}
     */
    MultiplyResponse getMultiplyResult(int a, int b);

    /**
     * @param a dividend
     * @param b divisor
     * @return ratio in SOAP response {@link DivideResponse}
     */
    DivideResponse getDivideResult(int a, int b);

    /**
     * @param a depreciate
     * @param b subtrahend
     * @return difference in SOAP response {@link SubtractResponse}
     */
    SubtractResponse getSubtractResult(int a, int b);
}
