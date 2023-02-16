package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class CreateNewSavingsAccountPage extends BasePage{
    @FindBy (xpath = "//*[text()='New Savings Account']")
    WebElement createNewSavingsTitle;
    @FindBy (xpath = "//*[@for='Savings']//input")
    WebElement savingsTypeRadio;
    @FindBy (xpath = "//*[@for='Individual']//input")
    WebElement individualOwnershipRadio;
    @FindBy (xpath = "//*[@class='col col-sm-4']//input")
    WebElement accountNameBar;
    @FindBy (xpath = "//*[@class='col col-sm-4']//*[@id='openingBalance']")
    WebElement initialDepositBar;
    @FindBy (id="newSavingsSubmit")
    WebElement submitBtn;



    public void verifyUserIsOnCreateNewSavingsPage(){
        Assert.assertTrue(createNewSavingsTitle.isDisplayed());
    }

    public void userFillsNewSavingsAccountInfo(){
        savingsTypeRadio.click();
        individualOwnershipRadio.click();
        accountNameBar.sendKeys(ConfigReader.getProperty("savings.name"));
        initialDepositBar.sendKeys(ConfigReader.getProperty("savings.deposit"));
    }

    public void userClickSubmitBtnForNewSavingsAccount(){
        submitBtn.click();
    }
}
