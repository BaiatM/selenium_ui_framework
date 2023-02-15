package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateNewSavingsAccountPage;
import pages.HomePage;
import pages.ViewSavingsAccounts;

public class SavingsAccountSteps {
    HomePage homePage = new HomePage();
    CreateNewSavingsAccountPage createSavingAcc = new CreateNewSavingsAccountPage();
    ViewSavingsAccounts viewSavingsAccounts = new ViewSavingsAccounts();
    @Given("user clicks on savings dropdown")
    public void user_clicks_on_savings_dropdown() {
        homePage.clickOnSavingsDropDown();
    }
    @Given("user is able to see ViewSavings and NewSavings options")
    public void user_is_able_to_see_view_savings_and_new_savings_options() {
        homePage.verifySavingsOptions();
    }
    @When("user clicks on New Savings option")
    public void user_clicks_on_new_savings_option() {
        homePage.clickOnNewSavingsOption();
    }
    @When("user is directed to creating a new savings account page")
    public void user_is_directed_to_creating_a_new_savings_account_page() {
        createSavingAcc.verifyCreateSavingsPage();
    }
    @When("user fills the page with related information")
    public void user_fills_the_page_with_related_information() {
        createSavingAcc.userFillsInfoForSavingsAcc();
    }
    @When("user directed to ViewSavingsAccounts")
    public void user_directed_to_view_savings_accounts() {
        viewSavingsAccounts.verifyViewSavingsAccountPage();
    }
    @When("user is able to see newly created savings account")
    public void user_is_able_to_see_newly_created_savings_account() {
        viewSavingsAccounts.verifyNewSavingAccIsVisible();
    }
    @Then("user verifies savings account information")
    public void user_verifies_savings_account_information() {
        viewSavingsAccounts.verifyAccountInfoMatchesExpected();
    }
}
