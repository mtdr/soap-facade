package com.edu.mtdr.soapfacade.service;

import com.edu.mtdr.soapfacade.model.soapMsgs.AddResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.DivideResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.MultiplyResponse;
import com.edu.mtdr.soapfacade.model.soapMsgs.SubtractResponse;

/**
 * Интерфейс сервиса калькулятора
 */
public interface ICalculatorService {
    /**
     * @param a слагаемое
     * @param b слагаемое
     * @return результат сложения - сумма - в объекте SOAP-ответа
     */
    AddResponse getAdditionResult(int a, int b);

    /**
     * @param a множитель
     * @param b множитель
     * @return результат умножения - произведение - в объекте SOAP-ответа {@link MultiplyResponse}
     */
    MultiplyResponse getMultiplyResult(int a, int b);

    /**
     * @param a делимое
     * @param b делитель
     * @return результат деления - частное - в объекте SOAP-ответа {@link DivideResponse}
     */
    DivideResponse getDivideResult(int a, int b);

    /**
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return результат вычитания - разность - в объекте SOAP-ответа {@link SubtractResponse}
     */
    SubtractResponse getSubtractResult(int a, int b);
}
