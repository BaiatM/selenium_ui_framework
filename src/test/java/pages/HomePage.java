package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy (xpath = "//*[text()='Welcome FirstName']")
    WebElement welcomeText;

    public void verifyPage(){
        Assert.assertTrue("Welcome test message is not visible, could be on wrong page", welcomeText.isDisplayed());
    }
}
