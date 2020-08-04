package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel(description = "Сообщение с ошибкой")
public class ErrorResponseMessage extends BaseResponseMessage {
    @ApiModelProperty("Причина ошибки")
    private String reason;

    public ErrorResponseMessage() {
        super(HttpStatus.NOT_FOUND.value(), false);
    }

    public ErrorResponseMessage(String reason, HttpStatus status) {
        super(status.value(), false);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
