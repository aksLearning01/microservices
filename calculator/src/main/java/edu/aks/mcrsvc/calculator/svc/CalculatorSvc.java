package edu.aks.mcrsvc.calculator.svc;

import edu.aks.mcrsvc.calculator.exception.CalculatorException;

import java.util.List;

public interface CalculatorSvc {

    public Double sum(List<String> list) throws CalculatorException;


    public Double difference(List<String> list) throws CalculatorException;


    public Double multiply(List<String> list) throws CalculatorException;


    public Double divide(List<String> list) throws CalculatorException;
}
