Feature: Deposit feature functionalities

  Background: User is logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @wip
  Scenario: User is able to deposit and check if deposit was successful
    Given user clicks on Deposit option
    And user is redirected to Deposit page
    When user chooses "deposit.to" account
    And user enters "deposit.amount" and clicks on submit button
    And user is redirected to view savings account page
    And user scrolls down until the transaction table is visible
    Then user should see "deposit.amount" in transactions table


  Scenario:

  Scenario: