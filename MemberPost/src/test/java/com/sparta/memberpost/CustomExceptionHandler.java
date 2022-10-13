package com.sparta.memberpost;


import com.sparta.memberpost.controller.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    private final MethodArgumentNotValidException methodArgumentNotValidException;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getValidate(MethodArgumentNotValidException ex) {
        //List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        //for (ObjectError error : allErrors) {
        //    log.error("error: {} ", error );
        //    log.error("error: {}", Arrays.toString(error.getCodes()));
        //}
        String field = ex.getBindingResult().getFieldError().getField();
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();

        return new ResponseEntity<>("field" + field, HttpStatus.valueOf("message" + message));
    }


}
