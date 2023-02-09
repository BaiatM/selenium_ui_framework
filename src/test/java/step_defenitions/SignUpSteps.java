package step_defenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class SignUpSteps  {
    SignUpPage signUpPage = new SignUpPage();
    FirstFillOutFormPage firstFillOutFormPage = new FirstFillOutFormPage();
    SecondFillOutFormPage secondFillOutFormPage = new SecondFillOutFormPage();
    @Given("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        signUpPage.userIsClickingSignUpBtn();
    }

    @Given("user fills the form")
    public void user_fills_the_form() {
        firstFillOutFormPage.fillTheFirstPageOfSignUp();

    }

    @When("user clicks the next button")
    public void user_clicks_the_next_button() {
        firstFillOutFormPage.clickNextBtn();
    }

    @When("user fills the form for the second page")
    public void user_fills_the_form_for_the_second_page() {
        secondFillOutFormPage.fillTheSecondSignUpPage();
    }
    @When("user clicks the register button")
    public void user_clicks_the_register_button() {
        secondFillOutFormPage.clickRegisterBtn();
    }
}
