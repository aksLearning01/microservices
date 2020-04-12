package edu.aks.mcrsvc.calculator.svc;

import edu.aks.mcrsvc.calculator.exception.CalculatorException;
import edu.aks.mcrsvc.calculator.exception.ErrorMessages;
import edu.aks.mcrsvc.calculator.operate.CalcOperation;
import edu.aks.mcrsvc.calculator.util.CommonUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CalculatorService")
@Log4j
public class CalculatorSvcImpl implements CalculatorSvc {

    @Autowired
    CommonUtils utils;

    @Autowired
    CalcOperation operate;

    @Override
    public Double sum(List<String> list) throws CalculatorException {
        log.debug("CalculatorSvcImpl :: sum() :: started");
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.sum(numbers);
        } catch (NumberFormatException nfe) {
            log.debug("CalculatorSvcImpl :: sum() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            log.debug("CalculatorSvcImpl :: sum() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        log.debug("CalculatorSvcImpl :: sum() :: finished");
        return result;
    }

    @Override
    public Double difference(List<String> list) throws CalculatorException {
        log.debug("CalculatorSvcImpl :: difference() :: started");
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.difference(numbers);
        } catch (NumberFormatException nfe) {
            log.debug("CalculatorSvcImpl :: difference() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            log.debug("CalculatorSvcImpl :: difference() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        log.debug("CalculatorSvcImpl :: difference() :: finished");
        return result;
    }

    @Override
    public Double multiply(List<String> list) throws CalculatorException {
        log.debug("CalculatorSvcImpl :: multiply() :: started");
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.multiply(numbers);
        } catch (NumberFormatException nfe) {
            log.debug("CalculatorSvcImpl :: multiply() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (Exception nfe) {
            log.debug("CalculatorSvcImpl :: multiply() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        log.debug("CalculatorSvcImpl :: multiply() :: finished");
        return result;
    }

    @Override
    public Double divide(List<String> list) throws CalculatorException {
        log.debug("CalculatorSvcImpl :: divide() :: started");
        Double result = 0.0;
        try {
            List<Double> numbers = utils.convert(list);
            result = operate.divide(numbers);
        } catch (NumberFormatException nfe) {
            log.debug("CalculatorSvcImpl :: divide() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.IN);
        } catch (CalculatorException ce) {
            throw ce;
        } catch (Exception nfe) {
            log.debug("CalculatorSvcImpl :: divide() :: exception ::" + nfe.getMessage(), nfe);
            throw new CalculatorException(nfe, ErrorMessages.SVC_FAIL);
        }
        log.debug("CalculatorSvcImpl :: divide() :: finished");
        return result;
    }
}
