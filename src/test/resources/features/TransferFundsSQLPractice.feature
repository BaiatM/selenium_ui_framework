Feature: Transfer funds feature
  Background: User is logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @wip
  Scenario: User is able to verify transfer amount
    Given user clicks on Transfer Between Accounts option
    And user is redirected to Internal Transfer page
    And user selects from account and to account in internal page
    And user enters transfer amount
    When user clicks on submit button on Internal Transfer page
    And user is redirected to view checking accounts
    And user scrolls down until the transaction table is visible
    Then verify transaction details are updated in actual database


