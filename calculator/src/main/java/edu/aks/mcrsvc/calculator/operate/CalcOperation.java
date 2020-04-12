package edu.aks.mcrsvc.calculator.operate;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalcOperation {

    public Double sum(List<Double> numberList) {
        Double sum = 0.0;
        if (null != numberList && !numberList.isEmpty()) {
            for (Double no : numberList) {
                sum = sum + no;
            }
        }
        return sum;
    }

    public Double difference(List<Double> numberList) {
        Double difference = 0.0;
        if (null != numberList && !numberList.isEmpty()) {
            difference = numberList.get(0);
            numberList.remove(0);
            for (Double no : numberList) {
                difference = difference - no;
            }
        }
        return difference;
    }


    public Double multiply(List<Double> numberList) {
        Double product = 0.0;
        if (null != numberList && !numberList.isEmpty()) {
            product = numberList.get(0);
            numberList.remove(0);
            for (Double no : numberList) {
                product = product * no;
            }
        }
        return product;
    }

    public Double divide(List<Double> numberList) {
        Double division = 0.0;
        if (null != numberList && !numberList.isEmpty()) {
            division = numberList.get(0);
            numberList.remove(0);
            for (Double no : numberList) {
                if (no == 0.0) {
                    return -0.0;
                }
                division = division / no;
            }
        }
        return division;
    }
}
