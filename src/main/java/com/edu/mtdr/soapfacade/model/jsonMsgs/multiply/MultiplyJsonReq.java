package com.edu.mtdr.soapfacade.model.jsonMsgs.multiply;

public class MultiplyJsonReq {
    int a;
    int b;

    public MultiplyJsonReq() {
    }

    public MultiplyJsonReq(int a, int b) {
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
