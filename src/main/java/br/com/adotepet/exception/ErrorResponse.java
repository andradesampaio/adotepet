package br.com.adotepet.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    private String message;
    @JsonProperty("error_code")
    private String errorCode;

    public ErrorResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
