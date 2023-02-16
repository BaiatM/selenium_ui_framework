package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DepositPage;
import pages.HomePage;
import pages.ViewSavingsAccountsPage;

public class DepositSteps {
    HomePage homePage = new HomePage();
    DepositPage depositPage = new DepositPage();
    ViewSavingsAccountsPage viewSavingsAccountsPage = new ViewSavingsAccountsPage();
    @Given("user clicks on Deposit option")
    public void userClicksOnDepositOption() {
        homePage.userClicksOnDepositBtn();
    }

    @And("user is redirected to Deposit page")
    public void userIsRedirectedToDepositPage() {
        depositPage.verifyDepositPage();
    }

    @When("user chooses {string} account")
    public void userChoosesAccount(String depositTo) {
        depositPage.userChoosesAccountForDeposit(depositTo);
    }

    @And("user enters {string} and clicks on submit button")
    public void userEntersDepositAmountAndClicksOnSubmitButton(String depositAmount) {
        depositPage.userEntersDepositAndClicksOnSubmit(depositAmount);
    }

    @Then("user should see {string} in transactions table")
    public void userShouldSeeInTransactionsTable(String depositAmount) {
        viewSavingsAccountsPage.userVerifiesDepositAmountInTransactionsTable(depositAmount);
    }
}
