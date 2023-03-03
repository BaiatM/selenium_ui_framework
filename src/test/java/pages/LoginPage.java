package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends BasePage{
    @FindBy(id = "username")
    WebElement usernameBar;
    @FindBy(id = "password")
    WebElement passwordBar;
    @FindBy(id = "submit")
    WebElement signInBtn;
    @FindBy(id = "remember-me")
    WebElement rememberMeBtn;
    @FindBy(xpath = "//*[text()=' Sign Up Here']")
    WebElement signUpLink;


    public void enterValidLoginInfo(String str1,String str2){
        usernameBar.sendKeys(ConfigReader.getProperty(str1)); // ConfigReader.getProperty("valid.password")
        passwordBar.sendKeys(ConfigReader.getProperty(str2));

    }
    public void clickSignInBtn(){
        signInBtn.click();
    }

}
