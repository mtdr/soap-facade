package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel(description = "Operation response message")
public class CalcJsonResponseMessage extends BaseResponseMessage {
    @ApiModelProperty("Result")
    private int result;

    public CalcJsonResponseMessage() {
        super(HttpStatus.OK.value(), true);
    }

    public CalcJsonResponseMessage(int result) {
        super(HttpStatus.OK.value(), true);
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
