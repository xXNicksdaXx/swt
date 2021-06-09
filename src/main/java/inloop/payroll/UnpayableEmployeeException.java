package inloop.payroll;

public class UnpayableEmployeeException extends java.lang.Exception{
    private static final long serialVersionUID = 1;

    public UnpayableEmployeeException(String message){
        super(message);
    }
}
