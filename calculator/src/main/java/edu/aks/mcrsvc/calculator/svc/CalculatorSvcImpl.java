package edu.aks.mcrsvc.calculator.svc;

import edu.aks.mcrsvc.calculator.exception.CalculatorException;
import edu.aks.mcrsvc.calculator.exception.ErrorMessages;
import edu.aks.mcrsvc.calculator.operate.CalcOperation;
import edu.aks.mcrsvc.calculator.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CalculatorService")
public class CalculatorSvcImpl implements CalculatorSvc {

    @Autowired
    CommonUtils utils;

    @Autowired
    CalcOperation operate;

    @Override
    public Double sum(List<String> list) throws CalculatorException {
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.sum(numbers);
        } catch (NumberFormatException nfe) {
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        return result;
    }

    @Override
    public Double difference(List<String> list) throws CalculatorException {
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.difference(numbers);
        } catch (NumberFormatException nfe) {
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        return result;
    }

    @Override
    public Double multiply(List<String> list) throws CalculatorException {
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.multiply(numbers);
        } catch (NumberFormatException nfe) {
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        return result;
    }

    @Override
    public Double divide(List<String> list) throws CalculatorException {
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.divide(numbers);
            if (-0.0 == result) {
                throw new CalculatorException(ErrorMessages.NOT_DIV);
            }
        } catch (NumberFormatException nfe) {
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        return result;
    }
}
