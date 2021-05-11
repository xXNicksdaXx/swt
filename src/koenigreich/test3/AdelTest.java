package koenigreich.test3;

import junit.framework.TestCase;
import koenigreich.Adel;

public class AdelTest extends TestCase {

    private Adel adel;

    protected void setUp() {
        adel = new Adel();
    }

    public void testSteuerA1() {
        try {
            adel.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    public void testSteuerA2() {
        adel.setEinkommen(0);
        assertEquals(20, adel.steuer());
    }

    public void testSteuerA3() {
        adel.setEinkommen(10);
        assertEquals(20, adel.steuer());
    }

    public void testSteuerA4() {
        adel.setEinkommen(20);
        assertEquals(20, adel.steuer());
    }

    public void testSteuerA5() {
        adel.setEinkommen(253);
        assertEquals(25, adel.steuer());
    }
}
