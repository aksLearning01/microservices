package edu.aks.mcrsvc.calculator;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j
public class CalculatorApplication {

    public static void main(String[] args) {
        log.debug("CalculatorApplication started ");
        SpringApplication.run(CalculatorApplication.class, args);
    }

}
