package inloop;

import inloop.taxi.*;
import static inloop.leet.Leet.*;

public class Inloop {
    public static void main(String[] args) {
        //Taxi
        Human juergen = new Human("Juergen", "Staub");

        Human andrea = new Human("Andrea", "Bora");
        Human franzi = new Human("Franzi", "Ada");
        Human leah = new Human("Leah", "Posh");
        Human susi = new Human("Susi", "Fresh");
        Human lucky = new Human("Lucky", "Fuke");

        Taxi taxi = new Taxi(juergen);

        taxi.add(andrea);
        taxi.add(franzi);
        taxi.add(leah);
        taxi.add(susi);
        taxi.add(lucky);

        System.out.println(taxi);
        taxi.allGetOut();
        System.out.println(taxi);

        //Leet
        String[] test = new String[2];
        test[0] = "We are elite hackers!";
        test[1] = "Informatiker machen coole Sachen!";

        String[] mod = new String[2];
        mod = allToLeet(test);

        for (String m : mod){
            System.out.println(m);
        }
    }

}