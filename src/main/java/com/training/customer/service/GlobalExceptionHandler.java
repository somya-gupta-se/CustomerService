package com.training.customer.service;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().build().message(message).success(true).status(HttpStatus.NOT_FOUND);
        //.message(message).success(true).status(HttpStatus.NOT_FOUND);
        //ApiResponse.build().message(message).success(true).status(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ApiResponse)(response, HttpStatus.NOT_FOUND);
    }*/
}
