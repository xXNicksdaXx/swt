package koenigreich.test5;

import koenigreich.Adel;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdelTest {

    private Adel adel;

    @BeforeEach
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
