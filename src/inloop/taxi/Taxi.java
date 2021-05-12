package inloop.taxi;

public class Taxi {

    private Human driver;
    private Human [] passengers;
    private int count = 0;

    public Taxi (Human driver){
        this.driver = driver;
        passengers = new Human[4];
    }

    public String getDriverName(){
        return (driver.toString());
    }

    public void add(Human passenger){
        if (passenger == null) throw new IllegalArgumentException("Passenger darf nicht leer sein.");
        if (count >= 4){
            System.out.println("We are sorry, "+ passenger.toString() + ". The taxi is full.");
        }
        else {
            passengers[count] = passenger;
            count++;
            System.out.println(passenger.toString() + " gets in.");
        }
    }

    public String toString(){
        String text = "This is the taxi of " + getDriverName() + ". He takes ";
        switch(count){
            case 0:
                return text + "nobody along.";
            case 1:
                return text + passengers[0].toString() + " along.";
            case 2:
                return text + passengers[0].toString() + " and " + passengers[1].toString()+  " along.";
            case 3:
                return text + passengers[0].toString() + ", " + passengers[1].toString() + " and " + passengers[2].toString() + " along.";
            case 4:
                return text + passengers[0].toString() + ", " + passengers[1].toString() + ", " + passengers[2].toString() + " and " + passengers[3].toString() + " along.";
            default:
                throw new IllegalArgumentException("Count muss im Bereich 0-4 liegen.");

        }
    }

    public Human[] allGetOut(){
        if (count == 0) return new Human[0];
        else {
            Human[] hold = new Human[count];
            for (int i = 0; i < count; i++){
                hold[i] = passengers[i];
            }
            passengers = new Human[4];
            count = 0;
            return hold;
        }
    }

}