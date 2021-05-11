package library.hellolib;

public class HelloLibrary {

    // Simulation durch main()
    public static void main(String[] args) {
        System.out.println("Hello Library!");

        // Erzeugung eines Library-Objektes
        Library litlib = new Library();

        // Erzeugung von zwei Book-Objekten
        Book scythe = new Book("Scythe");
        scythe.getTitle();
        Book dune = new Book("Dune");
        dune.getTitle();

        // Nachricht an die Library, dass die Books aufgenommen werden sollen
        litlib.register(scythe);
        litlib.register(dune);
    }
}