package tests;

import org.junit.Test;
import utils.common.CommonTest;

public class RegistrationTest extends CommonTest {

    @Test
    public void error() throws InterruptedException {
        CommonTest.errorRegistrationTest();
    }
}

