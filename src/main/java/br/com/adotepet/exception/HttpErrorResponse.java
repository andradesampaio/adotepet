package br.com.adotepet.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class HttpErrorResponse extends RuntimeException {
    @JsonProperty("status_code")
    private HttpStatus statusCode;
    @JsonProperty("error_code")
    private ErrorEnum errorCode;

    public HttpErrorResponse(HttpStatus statusCode, ErrorEnum errorCode) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorEnum errorCode) {
        this.errorCode = errorCode;
    }
}
