package edu.aks.mcrsvc.calculator;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j
public class CalculatorApplication {
    @Value("${spring.application.name}")
    private static String name;

    public static void main(String[] args) {
        log.debug(name + " application started ");
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
