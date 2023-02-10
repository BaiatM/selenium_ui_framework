package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FirstFillOutFormPage extends BasePage{
    @FindBy (xpath = "//select[@name='title']")
    WebElement titleDropDown;
    @FindBy (xpath = "//*[@id='firstName']")
    WebElement firstName;
    @FindBy (xpath = "//*[@id='lastName']")
    WebElement lastName;
    @FindBy (xpath = "//*[@id='gender']") //input[@value='F']
    WebElement gender;
    @FindBy (xpath = "//*[@id='dob']")
    WebElement dateOfBirth;
    @FindBy (xpath = "//*[@id='ssn']")
    WebElement sSN;
    @FindBy (xpath = "//*[@id='emailAddress']")
    WebElement emailAddress;
    @FindBy (xpath = "//*[@id='password']")
    WebElement password;
    @FindBy (xpath = "//*[@id='confirmPassword']")
    WebElement confirmPassword;
    @FindBy (xpath = "//*[text()='Next']")
    WebElement nextBtn;


    public void fillTheFirstPageOfSignUp(){
        new Select(titleDropDown).selectByValue("Mr.");
        firstName.sendKeys("FirstName");
        lastName.sendKeys("LastName");
        gender.click();
        dateOfBirth.sendKeys("04/29/1975");
        sSN.sendKeys("989-30-7917");
        emailAddress.sendKeys("t@gmail.com");
        password.sendKeys("Nn123123");
        confirmPassword.sendKeys("Nn123123");
    }

    public void clickNextBtn(){
        nextBtn.click();
    }


}
