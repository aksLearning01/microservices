package edu.aks.mcrsvc.calculator.controller;

import edu.aks.mcrsvc.calculator.exception.InvalidInputControllerException;
import edu.aks.mcrsvc.calculator.exception.ErrorMessages;
import edu.aks.mcrsvc.calculator.exception.NotDivisbleControllerException;
import edu.aks.mcrsvc.calculator.exception.SvcFailedControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculatorExceptionController {

    @ExceptionHandler(value = InvalidInputControllerException.class)
    public ResponseEntity<Object> invalidInut(InvalidInputControllerException exception) {
        return new ResponseEntity<>(ErrorMessages.IN.getMsg(), HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(value = SvcFailedControllerException.class)
    public ResponseEntity<Object> svcFailed(SvcFailedControllerException exception) {
        return new ResponseEntity<>(ErrorMessages.SVC_FAIL.getMsg(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NotDivisbleControllerException.class)
    public ResponseEntity<Object> notDivisible(NotDivisbleControllerException exception) {
        return new ResponseEntity<>(ErrorMessages.NOT_DIV.getMsg(), HttpStatus.BAD_REQUEST);
    }


}
