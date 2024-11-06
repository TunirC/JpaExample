package com.incb.store_content_manager.controller;

import com.incb.store_content_manager.exception.EmptyCartException;
import com.incb.store_content_manager.exception.DBProcessException;
import com.incb.store_content_manager.exception.ProductNotAvailableException;
import com.incb.store_content_manager.model.ErrorResponseBody;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
@Slf4j
public class StoreContentControllerAdvise implements RequestBodyAdvice {

    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<ErrorResponseBody> handleProductNotAvailableException(ProductNotAvailableException productNotAvailableException) {
        ErrorResponseBody ProductNotAvailableExceptionResponse = constructErrorBody(HttpStatus.NOT_FOUND, productNotAvailableException.getMessage());
        return new ResponseEntity<>(ProductNotAvailableExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyCartException.class)
    public ResponseEntity<ErrorResponseBody> handleCartIsEmptyException(EmptyCartException emptyCartException) {
        ErrorResponseBody emptyCartExceptionResponse = constructErrorBody(HttpStatus.NOT_FOUND, emptyCartException.getMessage());
        return new ResponseEntity<>(emptyCartExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DBProcessException.class)
    public ResponseEntity<ErrorResponseBody> handleDBProcessException(DBProcessException dbProcessException) {
        ErrorResponseBody dbProcessExceptionResponse = constructErrorBody(HttpStatus.NOT_FOUND, dbProcessException.getMessage());
        return new ResponseEntity<>(dbProcessExceptionResponse, HttpStatus.NOT_FOUND);
    }

    public ErrorResponseBody constructErrorBody(HttpStatusCode code, String errorMessage) {
        return new ErrorResponseBody(
                code.value(),
                code,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                errorMessage
        );
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        log.info("incoming request capture: {}", inputMessage);
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
