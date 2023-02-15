package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.FindBy;
import utils.DriverUtils;

public class HomePage extends BasePage{
    @FindBy (xpath = "//*[text()='Welcome FirstName']")
    WebElement welcomeText;
    @FindBy (xpath = "//*[text()='Checking']")
    WebElement checkingDropDown;
    @FindBy (xpath = "//*[text()='View Checking']")
    WebElement viewCheckingOption;
    @FindBy (xpath = "//*[text()='New Checking']")
    WebElement newCheckingOption;
    @FindBy (id="savings-menu")
    WebElement savingsDropDown;
    @FindBy (xpath="//*[text()='View Savings']")
    WebElement viewSavingsOption;
    @FindBy (xpath="//*[text()='New Savings']")
    WebElement newSavingsOption;



    Actions actions = new Actions(DriverUtils.getDriver());

    public void verifyPage(){
        Assert.assertTrue("Welcome test message is not visible, could be on wrong page", welcomeText.isDisplayed());
    }

    public void clickOnCheckingDropDown(){
        checkingDropDown.click();
    }

    public void verifyCheckingOptions(){
        Assert.assertTrue(viewCheckingOption.isDisplayed());
        Assert.assertTrue(newCheckingOption.isDisplayed());
    }

    public void openNewCheckingInNewTab(){
        actions.keyDown(Keys.COMMAND).click(newCheckingOption).keyUp(Keys.COMMAND).build().perform();
    }
    public void clickOnSavingsDropDown(){
        savingsDropDown.click();
    }
    public void verifySavingsOptions(){
        Assert.assertTrue(viewSavingsOption.isDisplayed());
        Assert.assertTrue(newSavingsOption.isDisplayed());
    }
    public void clickOnNewSavingsOption(){
        newSavingsOption.click();
    }
}
