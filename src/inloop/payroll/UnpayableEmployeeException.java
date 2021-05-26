package inloop.payroll;

import java.io.Serial;

public class UnpayableEmployeeException extends java.lang.Exception{
    @Serial
    private static final long serialVersionUID = 1;

    public UnpayableEmployeeException(String message){
        super(message);
    }
}
