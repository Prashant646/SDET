package ui;

import org.aeonbits.owner.ConfigCache;
import org.prashant.config.ConfigFactory;
import org.prashant.config.FrameworkConfig;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        System.out.println(ConfigFactory.getConfig().browser());
    }
}
