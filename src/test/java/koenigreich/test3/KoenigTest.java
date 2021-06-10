package koenigreich.test3;

import junit.framework.TestCase;
import koenigreich.Koenig;

public class KoenigTest extends TestCase {

    private Koenig koenig;

    protected void setUp() {
        koenig = new Koenig();
    }

    public void testSteuerK1() {
        try {
            koenig.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    public void testSteuerK2() {
        koenig.setEinkommen(0);
        assertEquals(0, koenig.steuer());
    }

    public void testSteuerK3() {
        koenig.setEinkommen(10);
        assertEquals(0, koenig.steuer());
    }

    public void testSteuerK4() {
        koenig.setEinkommen(20);
        assertEquals(0, koenig.steuer());
    }

    public void testSteuerK5() {
        koenig.setEinkommen(253);
        assertEquals(0, koenig.steuer());
    }
}
