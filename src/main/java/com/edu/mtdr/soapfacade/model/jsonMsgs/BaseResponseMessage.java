package com.edu.mtdr.soapfacade.model.jsonMsgs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base JSON response message")
public abstract class BaseResponseMessage {
    @ApiModelProperty("Http result code")
    private final int statusCode;
    @ApiModelProperty("Flag of operation success")
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
