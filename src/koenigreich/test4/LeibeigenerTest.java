package koenigreich.test4;

import static org.junit.Assert.*;

import koenigreich.Leibeigener;
import org.junit.Before;
import org.junit.Test;

public class LeibeigenerTest {

    private Leibeigener leibeigener;

    @Before
    public void setUp() {
        leibeigener = new Leibeigener();
    }

    @Test
    public void testSteuerL1() {
        try {
            leibeigener.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    @Test
    public void testSteuerL2() {
        leibeigener.setEinkommen(0);
        assertEquals(1, leibeigener.steuer());
    }

    @Test
    public void testSteuerL3() {
        leibeigener.setEinkommen(12);
        assertEquals(1, leibeigener.steuer());
    }

    @Test
    public void testSteuerL4() {
        leibeigener.setEinkommen(22);
        assertEquals(1, leibeigener.steuer());
    }

    @Test
    public void testSteuerL5() {
        leibeigener.setEinkommen(253);
        assertEquals(24, leibeigener.steuer());
    }
}
