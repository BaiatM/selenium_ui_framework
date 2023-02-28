Feature: User is able to transfer between accounts

  Background: user us logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @Smoke
  Scenario Outline: User is able to transfer between accounts
    Given user clicks on Transfer Between Accounts option
    And user is redirected to Internal Transfer page
    And user chooses "<fromAccount>" and "<toAccount>"
    And user enters transfer "<transferAmount>"
    And user verifies that amount is less than available balance
    When user clicks on submit button on Internal Transfer page
    And user is redirected to view checking accounts
    And user scrolls down until the transaction table is visible
    Then user verifies "<transferAmount>" in transaction table
    Examples:
      | fromAccount | toAccount | transferAmount |
      | 1140        | 1149      | 47.50          |
      | 1882        | 1140      | 27.85          |
      | 1287        | 3485      | 100.00         |
      | 1924        | 2275      | 70.25          |
      #just to check if the step on line 13 works
      | 1140        | 3485      | 20000.00       |

  @Smoke
  Scenario Outline: User is not available to transfer more than available balance
    Given user clicks on Transfer Between Accounts option
    And user is redirected to Internal Transfer page
    And user chooses "<fromAccount>" and "<toAccount>"
    And user enters transfer "<transferAmount>"
    When user clicks on submit button on Internal Transfer page
    Then user should see an error popup
    Examples:
      | fromAccount | toAccount | transferAmount |
      | 1140        | 1149      | 12345          |
