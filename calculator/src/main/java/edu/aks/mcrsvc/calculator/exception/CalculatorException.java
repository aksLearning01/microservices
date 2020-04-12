package edu.aks.mcrsvc.calculator.exception;


public class CalculatorException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;


    private ErrorMessages errorMsg;

    public CalculatorException(ErrorMessages errorMsg) {
        super(errorMsg.getMsg());
        this.errorMsg = errorMsg;
    }

    public CalculatorException(Throwable cause, ErrorMessages errorMsg) {
        super(errorMsg.getMsg());
        this.errorMsg = errorMsg;
    }
}
