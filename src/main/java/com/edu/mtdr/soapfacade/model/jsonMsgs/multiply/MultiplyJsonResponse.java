package com.edu.mtdr.soapfacade.model.jsonMsgs.multiply;

public class MultiplyJsonResponse {
    int result;

    public MultiplyJsonResponse() {
    }

    public MultiplyJsonResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
