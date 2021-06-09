package koenigreich.test3;

import junit.framework.TestCase;
import koenigreich.Einwohner;

public class EinwohnerTest extends TestCase {

    protected Einwohner einwohner;

    protected void setUp() {
        einwohner = new Einwohner();
    }

    public void testSteuerE1() {
        try {
            einwohner.setEinkommen(-1);
            // fail lässt den Test fehlschlagen
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            // richtige Exception mit der richtigen Meldung aufgetreten?
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    public void testSteuerE2() {
        einwohner.setEinkommen(0);
        assertEquals(1, einwohner.steuer());
    }

    public void testSteuerE3() {
        einwohner.setEinkommen(20);
        assertEquals(2, einwohner.steuer());
    }

    public void testSteuerE4() {
        einwohner.setEinkommen(25);
        assertEquals(2, einwohner.steuer());
    }
}
