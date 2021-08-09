package pruefung.real;

public class Example {
    public static void main(String[] args) {
        Directory root = new Directory("MeinJavaProgramm");
        root.addNode(new File("README.txt", "Viel Erfolg in der Klausur!"));

        Directory srcDir = new Directory("src");
        Directory testDir = new Directory("tests");
        System.out.println("Entfernt falsch: " + !root.removeNode(srcDir));
        System.out.println("Eingefügt: " + root.addNode(srcDir));
        System.out.println("Eingefügt: " + root.addNode(testDir));
        System.out.println("Entfernt: " + root.addNode(testDir));
        System.out.println("Eingefügt: " + root.addNode(testDir));
        System.out.println("Eingefügt falsch: " + !root.addNode(null));
        System.out.println("Entfernt falsch: " + !root.removeNode(null));

        System.out.println("Eingefügt: " + srcDir.addNode(new File("Main.java", "public class Main {}")));
        System.out.println("Eingefügt: " + testDir.addNode(new File("MyTest.java", "public class MyTest {}")));

        System.out.println("Suche nach 'Erfolg': " + root.textSearch("Erfolg"));
        System.out.println("Suche nach 'class': " + root.textSearch("class"));
        System.out.println("Größe des Wurzelverzeichnisses: " + root.size());
        System.out.println("Einfügen funktioniert nicht: " + root.removeNode(null));
    }
}
