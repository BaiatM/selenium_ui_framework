package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Given("user enters valid {string} and {string}")
    public void user_enters_valid_username_and_password(String str, String str1) {
        loginPage.enterValidLoginInfo(str,str1);
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
