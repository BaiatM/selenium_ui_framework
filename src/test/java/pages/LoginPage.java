package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public void enterValidLoginInfo(){
        usernameBar.sendKeys("test1@gmail.com");
        passwordBar.sendKeys("TestPass1234");

    }
    public void clickSignInBtn(){
        signInBtn.click();
    }

}
