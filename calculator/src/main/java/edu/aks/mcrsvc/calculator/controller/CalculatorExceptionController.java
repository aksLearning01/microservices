package edu.aks.mcrsvc.calculator.controller;

import edu.aks.mcrsvc.calculator.exception.InvalidInputControllerException;
import edu.aks.mcrsvc.calculator.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculatorExceptionController {

    @ExceptionHandler(value = InvalidInputControllerException.class)
    public ResponseEntity<Object> exception(InvalidInputControllerException exception) {
        return new ResponseEntity<>(ErrorMessages.IN.getMsg(), HttpStatus.NOT_ACCEPTABLE);
    }
}
