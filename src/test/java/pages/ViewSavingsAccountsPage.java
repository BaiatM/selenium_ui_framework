package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import utils.ConfigReader;
import utils.DriverUtils;

import java.util.List;

public class ViewSavingsAccountsPage extends BasePage{
    @FindBy (xpath = "//*[text()='View Savings Accounts']")
    WebElement viewSavingsPageTitle;
    @FindBy (xpath = "//*[text()='Confirmation']")
    WebElement confirmationIcon;
    @FindBy (xpath = "//*[@class='card bg-flat-color-5 text-light']")
    List<WebElement> listOfAccounts;
    @FindBy (xpath = "//a[@aria-controls='transactionTable']")
    WebElement transactionsTable;
    @FindBy (xpath = "//*[@aria-describedby='transactionTable_info']")
    WebElement transactionDetails;
    @FindBy (xpath = "//*[@class='card bg-flat-color-5 text-light']//label")
    List<WebElement> listOfToggleBtns;

    JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
    public void verifyViewSavingsPage(){
        Assert.assertTrue(viewSavingsPageTitle.isDisplayed());
    }

    public void verifyConfirmationIcon(){
        Assert.assertTrue(confirmationIcon.isDisplayed());
    }

    public void verifyUserIsAbleToSeeNewlyCreatedAccount(){
        for(WebElement names: listOfAccounts){
            if(names.getText().contains(ConfigReader.getProperty("savings.name"))){
                System.out.println("Name of the account info "+names.getText());
                Assert.assertTrue("Name of the new savings account doesn't match",names.getText().contains(ConfigReader.getProperty("savings.name")));
                Assert.assertTrue("Type of the new savings account doesn't match",names.getText().contains(ConfigReader.getProperty("savings.accountType")));
                Assert.assertTrue("Ownership of the new savings account doesn't match",names.getText().contains(ConfigReader.getProperty("savings.ownership")));
                Assert.assertTrue("Balance of the new savings account doesn't match",names.getText().contains(ConfigReader.getProperty("savings.deposit")));
                System.out.println("Success!");
            }
        }
    }

    public void userScrollsDownToTransactionsTable(){
        js.executeScript("arguments[0].scrollIntoView();", transactionsTable);
        Assert.assertTrue(transactionsTable.isDisplayed());
    }

    public void userCanSeeTransactionDetails(){
        Assert.assertTrue(transactionDetails.isDisplayed());
        System.out.println(transactionDetails.getText());
    }

    public void userFindsTargetAccountAndActivatesIt(String targetAccount){
        for(int i=0;i<listOfAccounts.size();i++){
            if(listOfAccounts.get(i).getText().contains(ConfigReader.getProperty(targetAccount))){
                js.executeScript("arguments[0].scrollIntoView();", listOfAccounts.get(i));
                listOfToggleBtns.get(i).click();
            }
        }
    }

    public void userVerifiesDepositAmountInTransactionsTable(String depositAmount){
        Assert.assertTrue(transactionDetails.isDisplayed());
        System.out.println(transactionDetails.getText());
        Assert.assertTrue("Transactions table does not show deposit amount",
                transactionDetails.getText().contains(ConfigReader.getProperty(depositAmount)));
        System.out.println("SUCCESS!");
    }
}
