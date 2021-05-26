package inloop.payroll;

public class Appointee extends Employee{
    private int payday;
    private int hoursPerMonth;
    private double payPerHour;

    public Appointee(String id, int payday, int hoursPerMonth, double payPerHour) {
        super(id);
        if (payday < 1 || payday > 30) throw new IllegalArgumentException("dayOfMonth should be 1-30!");
        if (hoursPerMonth <= 0) throw new IllegalArgumentException("hoursPerMonth should be greater than 0!");
        if (payPerHour <= 0) throw new IllegalArgumentException("payPerHour should be greater than 0!");
        this.payday = payday;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 30) throw new IllegalArgumentException("dayOfMonth should be 1-30!");
        if (dayOfMonth == payday) return true;
        else return false;
    }

    @Override
    public double calculatePay() {
        return hoursPerMonth * payPerHour;
    }

    @Override
    public double calculateDeductions() {
        return calculatePay() * 0.4;
    }
}
