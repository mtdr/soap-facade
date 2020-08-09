package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Operation request message")
public class CalcJsonRequestMessage {
    @ApiModelProperty("Argument 'a'")
    private int a;
    @ApiModelProperty("Argument 'b'")
    private int b;

    public CalcJsonRequestMessage() {
    }

    public CalcJsonRequestMessage(int a, int b) {
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
