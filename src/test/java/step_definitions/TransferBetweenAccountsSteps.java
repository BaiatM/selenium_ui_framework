package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.InternalTransferPage;
import pages.ViewCheckingAccountsPage;
import utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferBetweenAccountsSteps {

    HomePage homePage = new HomePage();
    InternalTransferPage internalTransferPage = new InternalTransferPage();
    ViewCheckingAccountsPage checkingAccountsPage = new ViewCheckingAccountsPage();
    @Given("user clicks on Transfer Between Accounts option")
    public void userClicksOnTransferBetweenAccountsOption() {
        homePage.userClicksOnTransferBetweenAccountsOption();
    }

    @And("user is redirected to Internal Transfer page")
    public void userIsRedirectedToInternalTransferPage() {
        internalTransferPage.verifyInternalTransferPage();
    }

    @And("user chooses {string} and {string}")
    public void userChoosesAnd(String fromAccount, String toAccount) {
        internalTransferPage.userChoosesFromAccountAndToAccount(fromAccount,toAccount);
    }

    @And("user enters transfer {string}")
    public void userEntersTransfer(String transferAmount) {
        internalTransferPage.userEntersTransferAmount(transferAmount);
    }

    @When("user clicks on submit button on Internal Transfer page")
    public void userClicksOnSubmitButtonOnInternalTransferPage() {
        internalTransferPage.userClicksSubmitBtn();
    }

    @Then("user verifies {string} in transaction table")
    public void userVerifiesTransferAmountInTransactionTable(String transferAmount) {
        checkingAccountsPage.userVerifiesTransferAmountInTransactionTable(transferAmount);
    }

    @And("user verifies that amount is less than available balance")
    public void userVerifiesThatAmountIsLessThanAvailableBalance() {
        internalTransferPage.verifyTransferAmountIsLessThanAvailableBalance();
    }

    @Then("user should see an error popup")
    public void userShouldSeeAnErrorPopup() {
        internalTransferPage.verifyErrorMessage();
    }

    @And("user selects from account and to account in internal page")
    public void userSelectsFromAccountInInternalPage() {
        internalTransferPage.userChoosesFromAccountAndToAccountSQLPractice();
    }

    @Then("verify transaction details are updated in actual database")
    public void verifyTransactionDetailsAreUpdatedInActualDatabase() {
       internalTransferPage.userVerifiesTransferAmountWithActualDatabaseSQLPractice();

    }

    @And("user enters transfer amount")
    public void userEntersTransferAmount() {
        internalTransferPage.userEntersTransferAmountSQLPractice();
    }
}
