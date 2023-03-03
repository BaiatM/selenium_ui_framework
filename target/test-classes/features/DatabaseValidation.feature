Feature: Validation of a new checking account

  Background: User is logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account

  @DB
  Scenario: User is able to create a new checking account with valid credentials
    Given user is clicking on Checking dropdown and seeing following options: View Checking, New Checking
    And user is opening new tab by clicking on New Checking option
    And user is changing to new checking tab
    And user is able to see all related labels
    When user fills the information for new checking account with the name "MYQSLPractice0215"
    And user clicks on submit button
    Then verify user created new account in the database with the "MYQSLPractice0215"
    Then clean up the database "MYQSLPractice0215"