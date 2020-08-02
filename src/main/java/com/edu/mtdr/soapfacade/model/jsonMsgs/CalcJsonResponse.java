package com.edu.mtdr.soapfacade.model.jsonMsgs;

public class CalcJsonResponse {
    int result;

    public CalcJsonResponse() {
    }

    public CalcJsonResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
