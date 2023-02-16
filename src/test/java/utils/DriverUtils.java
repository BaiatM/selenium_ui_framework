package utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {
    static WebDriver driver;

    public static void createDriver(Scenario scenario){
        //set up if statements to determine what the app.host
        if(ConfigReader.getProperty("app.host").equalsIgnoreCase("localhost")) {
            switch (ConfigReader.getProperty("app.browser")) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    //WebDriverManager essentially removes the need to manually manage any drivers. We can use it both "download"
                    //and manage the drivers.
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            //else if the value of app.host is saucelabs we are setting up a RemoteDriver to run tests on saucelabs
        }else if(ConfigReader.getProperty("app.host").equalsIgnoreCase("saucelabs")){
            //we r setting up mutable capabilities which are essentially settings and values that the driver requires
            //the sauceOptions variable is used to store the username and accesskey for ur saucelabs account
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username",ConfigReader.getProperty("sauce.username"));
            sauceOptions.setCapability("accesskey",ConfigReader.getProperty("sauce.accessKey"));

            //the capabilities variable is used to store all the general driver/platform info as well as pass the sauce options to the hub
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName",ConfigReader.getProperty("sauce.browserName"));
            capabilities.setCapability("browserVersion",ConfigReader.getProperty("sauce.browserVersion"));
            capabilities.setCapability("platformName",ConfigReader.getProperty("sauce.platformName"));
            capabilities.setCapability("sauce:options",sauceOptions);

            try {
                //here we r initializing the WebDriver to a remote driver and passing the URL to the Selenium grid hub
                //and passing the necessary capabilities
                driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("sauce.urlWest")),capabilities);
                //casting a driver into javascriptexecutor and using .execute method to pass
                //the scenario name to sauce labs
                ((JavascriptExecutor)driver).executeScript("sauce:job-name="+scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(ConfigReader.getProperty("app.baseurl"));
    }

    public static void quitDriver(Scenario scenario){
        if(ConfigReader.getProperty("app.host").equalsIgnoreCase("saucelabs")){
            ((JavascriptExecutor)driver).executeScript("sauce:job-result="+
                    (scenario.isFailed()?"failed":"passed"));
        }
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}