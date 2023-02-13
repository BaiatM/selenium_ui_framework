Feature: Login feature
@wip4
  Scenario: Verify user is able to login with valid credentials
    Given user enters valid username and password
    When user clicks on sign in button
    Then verify user is successfully logged in to the account