package com.cg.apps.productms.controllers;
import com.cg.apps.productms.exceptions.ProductNotFoundException;
import com.cg.apps.productms.exceptions.InvalidPriceException;
import com.cg.apps.productms.exceptions.InvalidProductIdException;
import com.cg.apps.productms.exceptions.InvalidProductNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFound(ProductNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProductIdException.class)
    public String handleInvalidId(InvalidProductIdException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProductNameException.class)
    public String handleInvalidName(InvalidProductNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPriceException.class)
    public String handleInvalidPrice(InvalidPriceException e){
        return e.getMessage();
    }


}
