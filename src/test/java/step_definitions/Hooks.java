package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.DriverUtils;

public class Hooks {
    @Before
    public void setUp(Scenario scenario){
        ConfigReader.initializeProperties();
        DriverUtils.createDriver(scenario);
    }
    @After
    public void cleanUp(Scenario scenario){
        DriverUtils.quitDriver(scenario);
    }
}