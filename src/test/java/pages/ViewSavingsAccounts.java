package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class ViewSavingsAccounts extends BasePage{
    @FindBy(xpath="//*[text()='View Savings Accounts']")
    WebElement viewSavingsAccountTitle;
    @FindBy(className="h4 m-0")
    WebElement nameOfNewSavingsAcc;

    public void verifyViewSavingsAccountPage(){
        Assert.assertTrue(viewSavingsAccountTitle.isDisplayed());
    }

    public void verifyNewSavingAccIsVisible(){
        String expected = ConfigReader.getProperty("savings.name");
        String actual = nameOfNewSavingsAcc.getText();
        Assert.assertEquals("The name of the newly created savings account is not matching",expected,actual);
    }

    public void verifyAccountInfoMatchesExpected(){
        String contentOfAccount = nameOfNewSavingsAcc.getText();
        Assert.assertTrue(contentOfAccount.contains("savings.name"));
        Assert.assertTrue(contentOfAccount.contains("savings.account_type"));
        Assert.assertTrue(contentOfAccount.contains("savings.ownership"));
        Assert.assertTrue(contentOfAccount.contains("savings.deposit"));

    }
}
