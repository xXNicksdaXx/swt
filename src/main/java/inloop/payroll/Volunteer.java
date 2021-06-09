package inloop.payroll;

import java.util.NoSuchElementException;

public class Volunteer extends Employee{

    public Volunteer(String id) {
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 30) throw new IllegalArgumentException("dayOfMonth should be 1-30!");
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException{
        throw new UnpayableEmployeeException("a volunteer does not receive payment!");
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }
}
