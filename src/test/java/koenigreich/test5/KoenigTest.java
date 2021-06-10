package koenigreich.test5;

import koenigreich.Koenig;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class KoenigTest {

    private Koenig koenig;

    @Before
    public void setUp() {
        koenig = new Koenig();
    }

    @Test
    public void testSteuerK1() {
        try {
            koenig.setEinkommen(-1);
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            assertEquals("Einkommen darf nicht negativ sein", e.getMessage());
        }
    }

    @Test
    public void testSteuerK2() {
        koenig.setEinkommen(0);
        assertEquals(0, koenig.steuer());
    }

    @Test
    public void testSteuerK3() {
        koenig.setEinkommen(10);
        assertEquals(0, koenig.steuer());
    }

    @Test
    public void testSteuerK4() {
        koenig.setEinkommen(20);
        assertEquals(0, koenig.steuer());
    }

    @Test
    public void testSteuerK5() {
        koenig.setEinkommen(253);
        assertEquals(0, koenig.steuer());
    }
}
