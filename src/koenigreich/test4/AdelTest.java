package koenigreich.test4;

import static org.junit.Assert.*;

import koenigreich.Adel;
import org.junit.Before;
import org.junit.Test;

public class AdelTest {

    private Adel adel;

    @Before
    public void setUp() {
        adel = new Adel();
    }

    @Test
    public void testSteuerA1() {
        try {
            adel.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    @Test
    public void testSteuerA2() {
        adel.setEinkommen(0);
        assertEquals(20, adel.steuer());
    }

    @Test
    public void testSteuerA3() {
        adel.setEinkommen(10);
        assertEquals(20, adel.steuer());
    }

    @Test
    public void testSteuerA4() {
        adel.setEinkommen(20);
        assertEquals(20, adel.steuer());
    }

    @Test
    public void testSteuerA5() {
        adel.setEinkommen(253);
        assertEquals(25, adel.steuer());
    }
}
