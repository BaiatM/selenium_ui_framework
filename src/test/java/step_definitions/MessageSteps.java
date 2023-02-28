package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class MessageSteps {
    HomePage homePage = new HomePage();
    @Given("user has clicked message-email navigation bar icon")
    public void userHasClickedMessageEmailNavigationBarIcon() {
        homePage.clickOnEmailIcon();
    }

    @And("has seen the number of messages in the icon's badge")
    public void hasSeenTheNumberOfMessagesInTheIconSBadge() {
        homePage.numberOfMessagesAreVisible();
    }

    @Then("user should see on-screen message confirming the number of Unread Messages matches badge number")
    public void userShouldSeeOnScreenMessageConfirmingTheNumberOfUnreadMessagesMatchesBadgeNumber() {
        homePage.verifyTextOfNewMails();
    }
}
