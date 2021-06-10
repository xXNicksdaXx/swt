package koenigreich.test3;

import junit.framework.*;
import junit.swingui.TestRunner;

public class AlleTestsKoenigreich {

    public static Test suite() {
        TestSuite suite = new TestSuite("AlleTestsKoenigreich");
        suite.addTestSuite(EinwohnerTest.class);
        suite.addTestSuite(KoenigTest.class);
        suite.addTestSuite(AdelTest.class);
        suite.addTestSuite(BauerTest.class);
        suite.addTestSuite(LeibeigenerTest.class);
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(AlleTestsKoenigreich.class);
    }
}