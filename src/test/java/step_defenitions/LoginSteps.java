package step_defenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.html.HTMLOptionElement;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Given("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterValidLoginInfo();
    }

    @When("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickSignInBtn();
    }

    @Then("verify user is successfully logged in to the account")
    public void verify_user_is_successfully_logged_in_to_the_account() {
        homePage.verifyPage();
    }

}
