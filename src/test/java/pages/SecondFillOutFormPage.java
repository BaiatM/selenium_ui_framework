package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondFillOutFormPage extends BasePage{

    @FindBy (xpath = "//*[@id='address']")
    WebElement address;
    @FindBy (xpath = "//*[@id='locality']")
    WebElement locality;
    @FindBy (xpath = "//*[@id='region']")
    WebElement region;
    @FindBy (xpath = "//*[@id='postalCode']")
    WebElement postalCode;
    @FindBy (xpath = "//*[@id='country']")
    WebElement country;
    @FindBy (xpath = "//*[@id='homePhone']")
    WebElement homePhone;
    @FindBy (xpath = "//*[@id='mobilePhone']")
    WebElement mobilePhone;
    @FindBy (xpath = "//*[@id='workPhone']")
    WebElement workPhone;
    @FindBy (xpath = "//*[@id='agree-terms']")
    WebElement agreeBtn;
    @FindBy (xpath = "//*[text()='Register']")
    WebElement registerBtn;

    public void fillTheSecondSignUpPage(){
        address.sendKeys("345 Victoria Avenue");
        locality.sendKeys("Mississauga");
        region.sendKeys("ON");
        postalCode.sendKeys("98765");
        country.sendKeys("Canada");
        homePhone.sendKeys("6479069067");
        mobilePhone.sendKeys("6479069067");
        workPhone.sendKeys("6479069067");
        agreeBtn.click();
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

}
