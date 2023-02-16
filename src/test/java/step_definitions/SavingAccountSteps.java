package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateNewCheckingAccountPage;
import pages.CreateNewSavingsAccountPage;
import pages.HomePage;
import pages.ViewSavingsAccountsPage;

public class SavingAccountSteps {
    HomePage homePage = new HomePage();
    CreateNewSavingsAccountPage newSavingsPage = new CreateNewSavingsAccountPage();

    ViewSavingsAccountsPage viewSavingsAccountsPage = new ViewSavingsAccountsPage();

    @Given("user is able to see Savings dropdown and clicks on it")
    public void userIsAbleToSeeSavingsDropdownAndClicksOnIt() {
        homePage.userClicksOnSavingsDropDown();
    }

    @And("user clicks on New Savings option")
    public void userClicksOnNewSavingsOption() {
        homePage.clickOnNewSavingsOption();
    }

    @And("user is redirected to Create Savings page")
    public void userIsRedirectedToCreateSavingsPage() {
        newSavingsPage.verifyUserIsOnCreateNewSavingsPage();
    }

    @When("user fills the form with valid credentials")
    public void userFillsTheFormWithValidCredentials() {
        newSavingsPage.userFillsNewSavingsAccountInfo();
    }
    @And("user clicks on submit button for new savings account")
    public void userClicksOnSubmitButtonForNewSavingsAccount() {
        newSavingsPage.userClickSubmitBtnForNewSavingsAccount();
    }

    @And("user is redirected to view savings account page")
    public void userIsRedirectedToViewSavingsAccountPage() {
        viewSavingsAccountsPage.verifyViewSavingsPage();
    }

    @And("user is able to see confirmation letter on top")
    public void userIsAbleToSeeConfirmationLetterOnTop() {
        viewSavingsAccountsPage.verifyConfirmationIcon();
    }

    @Then("user validates newly created account information")
    public void userValidatesNewlyCreatedAccountInformation() {
        viewSavingsAccountsPage.verifyUserIsAbleToSeeNewlyCreatedAccount();
    }

    @And("user clicks on View Savings option")
    public void userClicksOnViewSavingsOption() {
        homePage.userClicksOnViewSavingsOption();
    }

    @When("user scrolls down until the transaction table is visible")
    public void userScrollsDownUntilTheTransactionTableIsVisible() {
        viewSavingsAccountsPage.userScrollsDownToTransactionsTable();
    }

    @And("user should see all details about transactions")
    public void userShouldSeeAllDetailsAboutTransactions() {
        viewSavingsAccountsPage.userCanSeeTransactionDetails();
    }

    @And("user finds {string} and activates toggle button")
    public void userFindsAndActivatesToggleButton(String targetAccount) {
        viewSavingsAccountsPage.userFindsTargetAccountAndActivatesIt(targetAccount);
    }
}
