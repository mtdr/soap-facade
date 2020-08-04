package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiParam;

public class CalcJsonReq {
    @ApiParam(value = "a", example = "4100003")
    int a;
    int b;

    public CalcJsonReq() {
    }

    public CalcJsonReq(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
