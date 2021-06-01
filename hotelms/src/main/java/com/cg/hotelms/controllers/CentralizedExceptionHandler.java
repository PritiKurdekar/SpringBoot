package com.cg.hotelms.controllers;
import com.cg.hotelms.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.hotelms.exceptions.HotelNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HotelNotFoundException.class)
    public String handleHotelNotFound(HotelNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidHotelIdException.class)
    public String handleInvalidId(InvalidHotelIdException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidHotelNameException.class)
    public String handleInvalidName(InvalidHotelNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidHotelAddressException.class)
    public String handleInvalidAddress(InvalidHotelAddressException e){
        return e.getMessage();
    }


}
