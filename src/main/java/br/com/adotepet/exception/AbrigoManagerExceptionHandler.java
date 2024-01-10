package br.com.adotepet.exception;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

@ControllerAdvice
public class AbrigoManagerExceptionHandler {

    MessageSource messageSource;

    public AbrigoManagerExceptionHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    private static final Logger logger = LogManager.getLogger(AbrigoManagerExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleHttpApiException(HttpErrorResponse exception, Locale locale) {
        ErrorResponse errorResponse = fromError(exception.getErrorCode().toString(), locale);

        logger.warn("HttpApiException Error code {}, message {}", exception.getErrorCode(), errorResponse.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(errorResponse);
    }

    @ExceptionHandler(AbrigoBusinessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleAbrigoBusinessException(AbrigoBusinessException exception, Locale locale) {
        ErrorResponse errorResponse = fromError(exception.getErrorCode().toString(), locale);

        logger.warn("AbrigoBusinessException Error code {}, message {}", exception.getErrorCode(), errorResponse.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(errorResponse);
    }

    private ErrorResponse fromError(String errorCode, Locale locale){
        String message = "";
       try{
            message = messageSource.getMessage(errorCode, Stream.empty().toArray(), locale);
        }catch(NoSuchMessageException exception){
            logger.error("Could not find message for {} code {} locale", errorCode, locale);
        }
        return new ErrorResponse(errorCode, message);
    }
}
