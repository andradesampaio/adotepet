package br.com.adotepet.exception;

import org.springframework.http.HttpStatus;

public class AbrigoBusinessException extends RuntimeException {
    ErrorEnum errorCode;
    HttpStatus statusCode;
    public AbrigoBusinessException(ErrorEnum errorCode, HttpStatus statusCode ){
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public ErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorEnum errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}