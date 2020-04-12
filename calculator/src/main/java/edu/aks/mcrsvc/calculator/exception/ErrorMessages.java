package edu.aks.mcrsvc.calculator.exception;

public enum ErrorMessages {

    IN("Invalid input, only numbers are allowed", "INVALID_NUMBER"),
    SVC_FAIL("Service failed to provide resullt to desired output.Please try again", "SVC_FAILED"),
    NOT_DIV("Division by 0 is not allowed", "NOT_DIVISIBLE");

    private String msg;
    private String errorCode;

    ErrorMessages(String msg, String code) {
        this.msg = msg;
        this.errorCode = code;
    }

    ErrorMessages() {
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.errorCode;
    }

}
