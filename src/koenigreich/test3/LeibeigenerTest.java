package koenigreich.test3;

import junit.framework.TestCase;
import koenigreich.Leibeigener;

public class LeibeigenerTest extends TestCase {

    private Leibeigener leibeigener;

    protected void setUp() {
        leibeigener = new Leibeigener();
    }

    public void testSteuerL1() {
        try {
            leibeigener.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    public void testSteuerL2() {
        leibeigener.setEinkommen(0);
        assertEquals(1, leibeigener.steuer());
    }

    public void testSteuerL3() {
        leibeigener.setEinkommen(12);
        assertEquals(1, leibeigener.steuer());
    }

    public void testSteuerL4() {
        leibeigener.setEinkommen(22);
        assertEquals(1, leibeigener.steuer());
    }

    public void testSteuerL5() {
        leibeigener.setEinkommen(253);
        assertEquals(24, leibeigener.steuer());
    }
}
