package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class CreateNewSavingsAccountPage extends BasePage{
    @FindBy(xpath = "//*[text()='Create Savings']")
    WebElement createSavingsTitle;
    @FindBy(xpath = "//label[@for='Savings']//input")
    WebElement savingsRadioBox;
    @FindBy(xpath = "//label[@for='Individual']//input")
    WebElement individualRadioBox;
    @FindBy(xpath = "//input[@id='name']")
    WebElement accountNameBar;
    @FindBy(xpath = "//input[@id='openingBalance']")
    WebElement initialDepositBar;

    public void verifyCreateSavingsPage(){
        Assert.assertTrue(createSavingsTitle.isDisplayed());
    }
    public void userFillsInfoForSavingsAcc(){
        savingsRadioBox.click();
        individualRadioBox.click();
        //accountNameBar.sendKeys(ConfigReader.getProperty("savings.name"));
        accountNameBar.sendKeys("asdfasdf");
        initialDepositBar.sendKeys(ConfigReader.getProperty("savings.deposit"));
        initialDepositBar.getAttribute("class");
    }
}
