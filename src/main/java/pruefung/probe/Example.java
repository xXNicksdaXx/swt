package pruefung.probe;

/* Diese Datei wird nicht bewertet! Nutzen Sie sie gerne zum Testen. */
public class Example {
    public static void main(String[] args) {
        Investor erika = new Investor("Erika Mustermann");
        Investor max = new Investor("Max Mustermann");
        Stock tesla = new Stock("US88160R1014", "Tesla Inc.", 831.0);
        Stock apple = new Stock("US0378331005", "Apple Inc.", 128.91);

        tesla.addObserver(erika);
        tesla.addObserver(max);
        apple.addObserver(erika);

        tesla.setPrice(811.19);
        apple.setPrice(130.76);

        erika.buyShares(tesla, 500);
        erika.buyShares(apple, 200);
        System.out.println("Erikas Depot: $" + erika.valueOfDeposit());
    }
}
