package edu.aks.mcrsvc.calculator.controller;

import edu.aks.mcrsvc.calculator.exception.*;
import edu.aks.mcrsvc.calculator.svc.CalculatorSvc;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Log4j
public class CalculatorController {

    @Autowired
    CalculatorSvc calcSvc;

    //GET API for SUM
    @GetMapping("/sum")
    @ResponseBody
    public Double sum(@RequestParam List<String> values) {
        log.debug("CalculatorController:: sum() :: started");
        Double result = 0.0;
        try {
            result = calcSvc.sum(values);
        } catch (CalculatorException ce) {
            log.debug("CalculatorController :: sum() :: exception ::" + ce.getMessage(), ce);
            if (ce.getMessage().equalsIgnoreCase(ErrorMessages.IN.getMsg())) {
                throw new InvalidInputControllerException();
            } else {
                throw new SvcFailedControllerException();
            }
        }
        log.debug("CalculatorController:: sum() :: finished");
        return result;

    }

    //GET API for DIFFERENCE
    @GetMapping("/substract")
    public Double difference(@RequestParam List<String> values) {
        log.debug("CalculatorController:: difference() :: started");
        Double result = 0.0;
        try {
            result = calcSvc.difference(values);
        } catch (CalculatorException ce) {
            log.debug("CalculatorController :: sum() :: exception ::" + ce.getMessage(), ce);
            if (ce.getMessage().equalsIgnoreCase(ErrorMessages.IN.getMsg())) {
                throw new InvalidInputControllerException();
            } else {
                throw new SvcFailedControllerException();
            }
        }
        log.debug("CalculatorController:: difference() :: finished");
        return result;
    }

    //GET API for MULTIPLY
    @GetMapping("/multiply")
    public Double multiply(@RequestParam List<String> values) {
        log.debug("CalculatorController:: multiply() :: started");
        Double result = 0.0;
        try {
            result = calcSvc.multiply(values);
        } catch (CalculatorException ce) {
            log.debug("CalculatorController :: multiply() :: Exception ::" + ce.getMessage(), ce);
            if (ce.getMessage().equalsIgnoreCase(ErrorMessages.IN.getMsg())) {
                throw new InvalidInputControllerException();
            } else {
                throw new SvcFailedControllerException();
            }
        }
        log.debug("CalculatorController:: multiply() :: finished");
        return result;
    }


    //GET API for DIVISION
    @GetMapping("/divide")
    public Double divide(@RequestParam List<String> values) {
        log.debug("CalculatorController:: divide() :: started");
        Double result = 0.0;
        try {
            result = calcSvc.divide(values);
        } catch (CalculatorException ce) {
            log.debug("CalculatorController :: divide() :: Exception ::" + ce.getMessage(), ce);
            if (ce.getMessage().equalsIgnoreCase(ErrorMessages.IN.getMsg())) {
                throw new InvalidInputControllerException();
            } else if (ce.getMessage().equalsIgnoreCase(ErrorMessages.NOT_DIV.getMsg())) {
                throw new NotDivisbleControllerException();
            } else {
                throw new SvcFailedControllerException();
            }
        }
        log.debug("CalculatorController:: divide() :: finished");
        return result;
    }
}
