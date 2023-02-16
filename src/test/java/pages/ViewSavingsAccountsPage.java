package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import utils.ConfigReader;

import java.util.List;

public class ViewSavingsAccountsPage extends BasePage{
    @FindBy (xpath = "//*[text()='View Savings Accounts']")
    WebElement viewSavingsPageTitle;
    @FindBy (xpath = "//*[text()='Confirmation']")
    WebElement confirmationIcon;
    @FindBy (xpath = "//*[@class='h4 m-0']")
    List<WebElement> listOfNames;


    public void verifyViewSavingsPage(){
        Assert.assertTrue(viewSavingsPageTitle.isDisplayed());
    }

    public void verifyConfirmationIcon(){
        Assert.assertTrue(confirmationIcon.isDisplayed());
    }

    public void verifyUserIsAbleToSeeNewlyCreatedAccount(){
        for(WebElement names: listOfNames){
            if(names.getText().contains(ConfigReader.getProperty("savings.name"))){
                System.out.println("Name of the account is "+names.getText());
                Assert.assertTrue("Name of the new savings account doesn't match",names.getText().equals(ConfigReader.getProperty("savings.name")));
                System.out.println("Success!");
            }
        }
    }
}
