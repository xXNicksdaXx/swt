package stocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testet die Interaktion von {@link Stock}- und {@link Investor}-Objekten (Test
 * von Objektnetzen).
 */
class ChangeNotificationTest {
    private Investor investor;
    private Mailbox mailbox;
    private Stock stock;

    @BeforeEach
    void setUp() {
        investor = new Investor("Erika Musterfrau");
        mailbox = investor.getMailbox();
        stock = new Stock("DE1234567", "Beispiel AG", 15.37);
        stock.addWatcher(investor);
    }

    @Test
    void stockChangeNegativeValue() {
        try {
            stock.setPrice(-1);
            // fail lässt den Test fehlschlagen
            fail("Keine Exception aufgetreten");
        } catch (IllegalArgumentException e) {
            // richtige Exception mit der richtigen Meldung aufgetreten?
            assertEquals("newPrice cannot be negative!", e.getMessage());
        }
    }

    @Test
    void stockChangeZeroValue() {
        stock.setPrice(0);
        assertEquals(0.0, stock.getPrice());
    }

    @Test
    void notifyPriceChange(){
        int expected = mailbox.getSize() + 1;
        stock.setPrice(15.36);
        assertEquals(expected, mailbox.getSize());
    }

    @Test
    void dontNotifyPriceChange(){
        int expected = mailbox.getSize();
        stock.setPrice(15.38);
        assertEquals(expected, mailbox.getSize());
    }
}
