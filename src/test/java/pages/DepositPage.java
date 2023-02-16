package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

public class DepositPage extends BasePage{
    @FindBy(xpath = "//*[text()='Deposit into Account']")
    WebElement depositPageTitle;
    @FindBy (xpath="//select[@id='selectedAccount']")
    WebElement selectAccountDropDown;
    @FindBy (xpath="//*[@name='amount']")
    WebElement depositAmountBar;
    @FindBy (xpath = "//*[text()=' Submit']")
    WebElement submitBtn;

    public void verifyDepositPage(){
        Assert.assertTrue(depositPageTitle.isDisplayed());
    }

    public void userChoosesAccountForDeposit(String depositTo){
        new Select(selectAccountDropDown).selectByVisibleText(ConfigReader.getProperty(depositTo));
    }

    public void userEntersDepositAndClicksOnSubmit(String depositAmount){
        depositAmountBar.sendKeys(ConfigReader.getProperty(depositAmount));
        submitBtn.click();
    }
}
