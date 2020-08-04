package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel(description = "Сообщение с результатом вычислений")
public class CalcJsonResponseMessage extends BaseResponseMessage {
    @ApiModelProperty("Результат вычислений")
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
