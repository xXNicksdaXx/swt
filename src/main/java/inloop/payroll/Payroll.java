package inloop.payroll;

import java.util.List;

public class Payroll {
    private PayrollDisposition disposition;
    private int payday;

    public Payroll(PayrollDisposition disposition, int payday){
        if (disposition == null) throw new NullPointerException("disposition should never be null!");
        if (payday < 1 || payday > 30) throw new IllegalArgumentException("dayOfMonth should be 1-30!");
        this.disposition = disposition;
        this.payday = payday;
    }

    public void doPayroll(PayrollDB db) {
        if (db == null) throw new NullPointerException("db should never be null!");
        List<Employee> employees = db.getEmployeeList();

        for(Employee employee : employees){
            if (!employee.isPayday(payday)) continue;
            double payment;
            try{
                payment = employee.calculatePay() - employee.calculateDeductions();
            }
            catch(UnpayableEmployeeException uee){
                payment = 0;
                System.out.println(uee);
                System.out.println(("volunteer does not receive payment, payment set to 0."));
            }
            disposition.sendPayment(employee, payment);
        }
    }
}
