package koenigreich.test4;

import static org.junit.Assert.*;

import koenigreich.Einwohner;
import org.junit.Before;
import org.junit.Test;

public class EinwohnerTest {

    protected Einwohner einwohner;

    @Before
    public void setUp() {
        einwohner = new Einwohner();
    }

    @Test
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

    @Test
    public void testSteuerE2() {
        einwohner.setEinkommen(0);
        assertEquals(1, einwohner.steuer());
    }

    @Test
    public void testSteuerE3() {
        einwohner.setEinkommen(20);
        assertEquals(2, einwohner.steuer());
    }

    @Test
    public void testSteuerE4() {
        einwohner.setEinkommen(25);
        assertEquals(2, einwohner.steuer());
    }
}
