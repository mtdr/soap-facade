package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Сообщение с запросом вычислений")
public class CalcJsonRequestMessage {
    @ApiModelProperty("Аргумент 'a'")
    private int a;
    @ApiModelProperty("Аргумент 'b'")
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
