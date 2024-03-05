package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Before scenario");
    }

    @After
    public void tearDown() {
        System.out.println("After scenario");
        if (DriverManager.getDriver() != null) {
            DriverManager.closeDriver();
        }
    }

}
