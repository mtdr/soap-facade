package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Базовое сообщение")
public abstract class BaseResponseMessage {
    @ApiModelProperty("Код выполнения запроса")
    private final int statusCode;
    @ApiModelProperty("Признак успешности выполнения запроса")
    private final boolean isSuccess;

    public BaseResponseMessage(int statusCode, boolean isSuccess) {
        this.statusCode = statusCode;
        this.isSuccess = isSuccess;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
