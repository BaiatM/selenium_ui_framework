package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InternalTransferPage extends BasePage{
    @FindBy(xpath = "//h1[@id='page-title']")
    WebElement pageTitle;
    @FindBy(xpath = "//select[@id='fromAccount']")
    WebElement fromAccountDropDown;
    @FindBy(xpath = "//select[@id='toAccount']")
    WebElement toAccountDropDown;
    @FindBy (css ="#amount")
    WebElement transferAmountBar;
    @FindBy (xpath = "//*[text()=' Submit']")
    WebElement submitBtn;
    @FindBy (xpath="//small[@id='fromAccountBalance']")
    WebElement availableBalance;
    @FindBy (xpath = "//*[text()='Error']")
    WebElement errorMsg;


    double transferingAmount;
    public void verifyInternalTransferPage(){
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void userChoosesFromAccountAndToAccount(String fromAccount,String toAccount){
        new Select(fromAccountDropDown).selectByValue(fromAccount);
        new Select(toAccountDropDown).selectByValue(toAccount);
    }

    public void userEntersTransferAmount(String transferAmount){
        transferAmountBar.sendKeys(transferAmount);
        transferingAmount = Double.parseDouble(transferAmount);
    }

    public void verifyTransferAmountIsLessThanAvailableBalance(){
        double balance = Double.parseDouble(availableBalance.getText().substring(10));
        Assert.assertTrue("Insufficient funds for the transfer",balance>transferingAmount);
    }

    public void userClicksSubmitBtn(){
        submitBtn.click();
    }

    public void verifyErrorMessage(){
        Assert.assertTrue("The error message is not displayed", errorMsg.isDisplayed());
    }

    public void userChoosesFromAccountAndToAccountSQLPractice(){
        new Select(fromAccountDropDown).selectByValue("1146");
        new Select(toAccountDropDown).selectByValue("1140");
    }

    public void userEntersTransferAmountSQLPractice(){
        transferAmountBar.sendKeys("13.85");
    }

    public void userVerifiesTransferAmountWithActualDatabaseSQLPractice(){
        String data="";
        String msg = "The data is not matching!";
        try {
            ResultSet rs = DatabaseUtils.executeQuery("SELECT * FROM account_transaction ORDER BY transaction_date desc limit 1;");
            while(rs.next()){
                data =rs.getString(2); //
                System.out.println(rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(msg,data.contains("15.85"));
    }
}
