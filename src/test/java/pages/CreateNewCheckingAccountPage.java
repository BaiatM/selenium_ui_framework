package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.DriverUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateNewCheckingAccountPage extends BasePage{

    @FindBy (xpath = "//*[text()='New Checking Account']")
    WebElement newCheckingAccountTitle;
    @FindBy (xpath = "//*[text()='Select Checking Account Type']")
    WebElement selectCheckingType;
    @FindBy (xpath = "//*[@for='Standard Checking']//*[@type='radio']")
    WebElement standardCheckingRadio;
    @FindBy (xpath = "//*[@for='Interest Checking']//*[@type='radio']")
    WebElement interestCheckingRadio;
    @FindBy (xpath = "//*[text()='Select Account Ownership']")
    WebElement selectAccountOwnership;
    @FindBy (xpath = "//*[@for='Individual']//input")
    WebElement individualRadio;
    @FindBy (xpath = "//*[@for='Joint']//input")
    WebElement jointRadio;
    @FindBy (xpath = "//*[text()='Account Name']")
    WebElement accountName;
    @FindBy (xpath = "//div[@class='row form-group']//*[@id='name']")
    WebElement accountNameBar;
    @FindBy (xpath = "//*[text()='Initial Deposit Amount']")
    WebElement initialDeposit;
    @FindBy (xpath = "//div[@class='row form-group']//*[@id='openingBalance']")
    WebElement initialDepositBar;
    @FindBy (css = "#newCheckingSubmit")
    WebElement submitBtn;
    @FindBy (xpath = "//*[text()='Successfully created new Standard Checking account named Practice01']")
    WebElement confirmationMsg;



    public void verifyTheUserIsOnNewTab(){
        WebDriver driver = DriverUtils.getDriver();
        String primeWindowHandling = driver.getWindowHandle();
        List<String> listOfWindows = new ArrayList<>(driver.getWindowHandles());
        for(String handles: listOfWindows){
            if(!handles.equals(primeWindowHandling)){
                driver.switchTo().window(handles);
            }
        }
        Assert.assertTrue(newCheckingAccountTitle.isDisplayed());
    }

    public void verifyAllRelatedLabelsAndRadios(){
        Assert.assertTrue(selectCheckingType.isDisplayed());
        Assert.assertTrue(standardCheckingRadio.isDisplayed());
        Assert.assertTrue(interestCheckingRadio.isDisplayed());
        Assert.assertTrue(selectAccountOwnership.isDisplayed());
        Assert.assertTrue(individualRadio.isDisplayed());
        Assert.assertTrue(jointRadio.isDisplayed());
        Assert.assertTrue(accountName.isDisplayed());
        Assert.assertTrue(accountNameBar.isDisplayed());
        Assert.assertTrue(initialDeposit.isDisplayed());
        Assert.assertTrue(initialDepositBar.isDisplayed());
    }

    public void userProvidesValidInformation(){
        standardCheckingRadio.click();
        individualRadio.click();
        accountNameBar.sendKeys("Practice01");
        initialDepositBar.sendKeys("200");
    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public void verifyConfirmation(){
        Assert.assertTrue("Creation of new Standard Checking account is failed",confirmationMsg.isDisplayed());
    }
}