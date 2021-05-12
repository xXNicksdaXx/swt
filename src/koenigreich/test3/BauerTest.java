package koenigreich.test3;

import junit.framework.TestCase;
import koenigreich.Bauer;

public class BauerTest extends TestCase {

    // in der Bauer Klasse wird keine Methode überschrieben,
    // also muss sich der Bauer wie ein Einwohner verhalten
    // -> alle Tests des Einwohners kopiert

    private Bauer bauer;

    protected void setUp() {
        bauer = new Bauer();
    }

    public void testSteuerB1() {
        try {
            bauer.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    public void testSteuerB2() {
        bauer.setEinkommen(0);
        assertEquals(1, bauer.steuer());
    }

    public void testSteuerB3() {
        bauer.setEinkommen(20);
        assertEquals(2, bauer.steuer());
    }

    public void testSteuerB4() {
        bauer.setEinkommen(25);
        assertEquals(2, bauer.steuer());
    }
}
