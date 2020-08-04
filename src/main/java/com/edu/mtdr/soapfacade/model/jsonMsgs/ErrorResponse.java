package com.edu.mtdr.soapfacade.model.jsonMsgs;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    String reason;
    HttpStatus status;

    public ErrorResponse() {
    }

    public ErrorResponse(String reason, HttpStatus status) {
        this.reason = reason;
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
