package koenigreich.test4;

import static org.junit.Assert.*;

import koenigreich.Bauer;
import org.junit.Before;
import org.junit.Test;

public class BauerTest {

    // in der Bauer Klasse wird keine Methode überschrieben,
    // also muss sich der Bauer wie ein Einwohner verhalten
    // -> alle Tests des Einwohners kopiert

    private Bauer bauer;

    @Before
    public void setUp() {
        bauer = new Bauer();
    }

    @Test
    public void testSteuerB1() {
        try {
            bauer.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    @Test
    public void testSteuerB2() {
        bauer.setEinkommen(0);
        assertEquals(1, bauer.steuer());
    }

    @Test
    public void testSteuerB3() {
        bauer.setEinkommen(20);
        assertEquals(2, bauer.steuer());
    }

    @Test
    public void testSteuerB4() {
        bauer.setEinkommen(25);
        assertEquals(2, bauer.steuer());
    }
}
