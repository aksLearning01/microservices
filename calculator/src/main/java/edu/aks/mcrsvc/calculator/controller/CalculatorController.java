package edu.aks.mcrsvc.calculator.controller;

import edu.aks.mcrsvc.calculator.exception.CalculatorException;
import edu.aks.mcrsvc.calculator.exception.InvalidInputControllerException;
import edu.aks.mcrsvc.calculator.svc.CalculatorSvc;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        log.debug("The sum Rest API");
        Double result = 0.0;
        try {
            result = calcSvc.sum(values);
        } catch (CalculatorException ce) {
            throw new InvalidInputControllerException();
        }
        return result;

    }

    //GET API for DIFFERENCE
    @GetMapping("/substract")
    public Double difference(@RequestParam List<String> values) {
        log.debug("The sum Rest API");
        return null;
    }

    //GET API for MULTIPLY
    @GetMapping("/multiply")
    public Double multiply(@RequestParam List<String> values) {
        log.debug("The  Rest API  for Multiply");
        return null;
    }


    //GET API for MULTIPLY
    @GetMapping("/divide")
    public Double divide(@RequestParam List<String> values) {
        log.debug("The  Rest API  for  Division");
        return null;
    }
}
