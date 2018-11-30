package com.ds.admin.dsadmin.support;

import com.ds.admin.dsadmin.exception.DataNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception exception, WebRequest request) {
        return handleExceptionInternal(exception, "Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleEtc(Exception exception, WebRequest request) {
        return handleExceptionInternal(exception, "System Error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
