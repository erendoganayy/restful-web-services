package com.restful.rest.webservices.restfulwebservices.exception;

import com.restful.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustimizedResponseEntityExpectionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException
            (Exception ex, WebRequest request) throws Exception {
        ExpectionResponse expectionResponse= new ExpectionResponse(new Date(),ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity(expectionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException
            (UserNotFoundException ex, WebRequest request) throws Exception {
        ExpectionResponse expectionResponse= new ExpectionResponse(new Date(),ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity(expectionResponse,HttpStatus.NOT_FOUND);

    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExpectionResponse expectionResponse= new ExpectionResponse(new Date(),"Validation FaileD",
                ex.getBindingResult().toString());
        return new ResponseEntity(expectionResponse,HttpStatus.BAD_REQUEST);
    }

}
