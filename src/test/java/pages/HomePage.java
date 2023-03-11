package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.FindBy;
import utils.DriverUtils;

import java.util.logging.Logger;

public class HomePage extends BasePage{
    @FindBy (xpath = "//li[@class='active']")
    WebElement welcomeText;
    @FindBy (xpath = "//*[text()='Checking']")
    WebElement checkingDropDown;
    @FindBy (xpath = "//*[text()='View Checking']")
    WebElement viewCheckingOption;
    @FindBy (xpath = "//*[text()='New Checking']")
    WebElement newCheckingOption;
    @FindBy (id = "savings-menu")
    WebElement savingsDropDown;
    @FindBy (id = "new-savings-menu-item")
    WebElement newSavingsOption;
    @FindBy (id = "view-savings-menu-item")
    WebElement viewSavingsOption;
    @FindBy (xpath ="//*[text()='Deposit']")
    WebElement depositBtn;
    @FindBy (id="withdraw-menu-item")
    WebElement withdrawOption;
    @FindBy (xpath="//a[text()='Transfer Between Accounts']")
    WebElement transferBetweenAccountsOption;
    @FindBy (xpath ="//i[@class='ti-email']")
    WebElement emailIcon;
    @FindBy (xpath = "//span[@class='count bg-primary']")
    WebElement numberOfNewMails;
    @FindBy (xpath = "//div[3]//p[@style='width: max-content']")
    WebElement textOfNewMails;

    String newMessages;


    Actions actions = new Actions(DriverUtils.getDriver());
    Logger log = Logger.getLogger("ViewCheckingAccountsPage");

    public void verifyPage(){
        log.info("hello");
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

    public void userClicksOnSavingsDropDown(){
        Assert.assertTrue(savingsDropDown.isDisplayed());
        savingsDropDown.click();
    }

    public void clickOnNewSavingsOption(){
        newSavingsOption.click();
    }

    public void userClicksOnViewSavingsOption(){
        viewSavingsOption.click();
    }

    public void userClicksOnDepositBtn(){
        depositBtn.click();
    }

    public void userClicksOnWithdrawOption(){
        withdrawOption.click();
    }

    public void userClicksOnTransferBetweenAccountsOption(){
        transferBetweenAccountsOption.click();
    }

    public void clickOnEmailIcon(){
        emailIcon.click();
    }

    public void numberOfMessagesAreVisible(){
        Assert.assertTrue(numberOfNewMails.isDisplayed());
        newMessages = numberOfNewMails.getText();
    }

    public void verifyTextOfNewMails(){
        Assert.assertTrue("The number of new messages does not match with actual number of new emails",
                textOfNewMails.getText().contains(newMessages));
    }
}

