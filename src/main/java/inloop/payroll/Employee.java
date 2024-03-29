package inloop.payroll;

public abstract class Employee {
    private String id;

    public Employee(String id){
        if (id == null) throw new NullPointerException("id should never be null!");
        if (id.equals("")) throw new IllegalArgumentException("id should never be empty!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract boolean isPayday (int dayOfMonth);

    public abstract double calculatePay() throws UnpayableEmployeeException;

    public abstract double calculateDeductions();
}
