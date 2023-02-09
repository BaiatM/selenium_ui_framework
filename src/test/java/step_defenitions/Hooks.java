package step_defenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverUtils;

public class Hooks {
    @Before
    public void setUp(){
        DriverUtils.createDriver();
    }
    @After
    public void cleanUp(){
        DriverUtils.getDriver().quit();
    }
}
