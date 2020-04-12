package edu.aks.mcrsvc.calculator.util;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j
public class CommonUtils {

    public List<Double> convert(List<String> values) throws NumberFormatException {
        try {
            return values.stream().map(Double::parseDouble).collect(Collectors.toList());
        } catch (NumberFormatException nfe) {
            log.error("Exception while formatting numbers for operation ", nfe);
            throw nfe;
        }
    }
}
