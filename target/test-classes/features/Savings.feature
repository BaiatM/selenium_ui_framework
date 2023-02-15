Feature: User is able to see all saving bank accounts
  Scenario: test
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
    And user clicks on savings dropdown
    And user is able to see ViewSavings and NewSavings options
    When user clicks on New Savings option