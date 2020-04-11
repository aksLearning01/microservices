package edu.aks.mcrsvc.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CalculatorController {

    //GET API for SUM
    @GetMapping("/sum")
    public Double sum(@RequestParam List<String> values) {
        System.out.println("The sum Rest API");
        return null;

    }

    //GET API for DIFFERENCE
    @GetMapping("/substract")
    public Double difference(@RequestParam List<String> values) {
        System.out.println("The Difference Rest API");
        return null;
    }

    //GET API for MULTIPLY
    @GetMapping("/multiply")
    public Double multiply(@RequestParam List<String> values) {
        System.out.println("The  Rest API  for Multiply");
        return null;
    }


    //GET API for MULTIPLY
    @GetMapping("/divide")
    public Double divide(@RequestParam List<String> values) {
        System.out.println("The  Rest API  for  Division");
        return null;
    }
}
