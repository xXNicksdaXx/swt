package inloop.bank_account;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private double lineOfCredit;
    private AccountState state;

    public BankAccount(String accountNumber, double lineOfCredit){
        if (accountNumber == null) throw new NullPointerException("accountNumber cannot be null!");
        if (accountNumber.equals("")) throw new IllegalArgumentException("accountNumber cannot be empty!");
        if (lineOfCredit < 0) throw new IllegalArgumentException("lineOfCredit must be positive!");

        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.lineOfCredit = lineOfCredit;
        this.state = new Positive();
    }

    public boolean payIn(double amount){
        return state.payIn(amount);
    }

    public boolean payOff(double amount){
        return state.payOff(amount);
    }

    public boolean close(){
        if(balance == 0){
            state = new Closed();
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getState() {
        return state.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void payInterest(){
        state.payInterest();
    }

    public void printBalance(){
        state.printBalance();
    }

    //--------------STATE-CLASSES----------------------

    private abstract class AccountState {
        public boolean payIn(double amount){
            return false;
        }

        public boolean payOff(double amount){
            return false;
        }

        @Override
        public String toString(){
            if (this instanceof Positive) return "Positive";
            else if (this instanceof Negative) return "Negative";
            else if (this instanceof Frozen) return "Frozen";
            else if (this instanceof Closed) return "Closed";
            else throw new IllegalStateException("?????!");
        }

        public void payInterest(){
            throw new IllegalStateException("payInterest is not allowed in current state!");
        }

        public abstract void printBalance();
    }

    private class Positive extends AccountState{

        @Override
        public boolean payIn(double amount){
            if (amount <= 0) throw new IllegalArgumentException("amount should be positive!");
            balance += amount;
            return true;
        }

        @Override
        public boolean payOff(double amount){
            if (amount <= 0) throw new IllegalArgumentException("amount should be positive!");
            if(balance - amount >= 0) {
                balance -= amount;
                return true;
            }
            if(balance - amount > -lineOfCredit){
                balance -= amount;
                state = new Negative();
                return true;
            }
            if(balance - amount == -lineOfCredit){
                balance -= amount;
                state = new Frozen();
                return true;
            }
            else return false;
        }

        @Override
        public void payInterest(){
            balance *= 1.01;
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is POSITIVE: +"+getBalance()+".");
        }
    }

    private class Negative extends AccountState{
        @Override
        public boolean payIn(double amount){
            if (amount <= 0) throw new IllegalArgumentException("amount should be positive!");
            balance += amount;
            if(balance >= 0) state = new Positive();
            return true;
        }

        @Override
        public boolean payOff(double amount){
            if (amount <= 0) throw new IllegalArgumentException("amount should be positive!");
            if(balance - amount > -lineOfCredit){
                balance -= amount;
                return true;
            }
            if(balance - amount == -lineOfCredit){
                balance -= amount;
                state = new Frozen();
                return true;
            }
            else return false;
        }

        @Override
        public void payInterest(){
            balance *= 1.03;
            if(balance <= -lineOfCredit) state = new Frozen();
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: "+getBalance()+".");
        }
    }

    private class Frozen extends AccountState{
        @Override
        public boolean payIn(double amount){
            if (amount <= 0) throw new IllegalArgumentException("amount should be positive!");
            balance += amount;
            if(balance < 0) state = new Negative();
            else state = new Positive();
            return true;
        }

        @Override
        public void printBalance() {
            System.out.println("Balance is NEGATIVE: "+getBalance()+". You need to pay in money.");
        }

        @Override
        public void payInterest(){
            balance *= 1.05;
        }
    }

    private class Closed extends AccountState{
        @Override
        public void printBalance() {
            System.out.println("This account is CLOSED. The balance is 0.");
        }
    }

}
