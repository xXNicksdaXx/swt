package inloop.payroll;

import java.util.*;

public class PayrollDispositionImpl implements PayrollDisposition{
    private Map<Employee, Double> payments = new HashMap<>();

    public PayrollDispositionImpl(){
    }

    public double getTotal(){
        if (getPayments() == null) throw new NullPointerException("payments is not filled!");
        Collection<Double> onlyPay = payments.values();
        double total = 0;
        for (Double pay : onlyPay){
            total += pay;
        }
        return total;
    }

    public double getAverage(){
        if (payments.size() == 0) return 0;
        return getTotal() / payments.size();
    }

    public Map<Employee, Double> getPayments() {
        return payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        if (empl == null) throw new NullPointerException("empl should never be null!");
        if (payment <= 0) throw new IllegalArgumentException("payment should be greater than 0!");
        payments.put(empl, payment);
    }
}
