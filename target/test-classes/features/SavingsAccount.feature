Feature: Creating a new saving account
  Background: User is logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @Smoke
  Scenario: User is able to create a new saving account with valid credentials
    Given user is able to see Savings dropdown and clicks on it
    And user clicks on New Savings option
    And user is redirected to Create Savings page
    When user fills the form with valid credentials
    And user clicks on submit button for new savings account
    And user is redirected to view savings account page
    And user is able to see confirmation letter on top
    Then user validates newly created account information

  @Smoke
  Scenario: User is able to see Transactions table with all details
    Given user is able to see Savings dropdown and clicks on it
    And user clicks on View Savings option
    And user is redirected to view savings account page
    When user scrolls down until the transaction table is visible
    Then user should see all details about transactions

  @Smoke
  Scenario: User is able to check target account's transactions
    Given user is able to see Savings dropdown and clicks on it
    And user clicks on View Savings option
    And user finds "savings.targetAccount" and activates toggle button
    When user scrolls down until the transaction table is visible
    Then user should see all details about transactions




    #### AllSavingsAccounts###
    #
    ##>As a User,
    ##I want to have the ability to view all my Savings bank accounts
    ##so that I can manage my accounts and see account balance and transactions.

    ##Functionalities:
    ##1. After User creates a new savings account, user should be able to view savings account information.
    ####All information should match the entered values during the submission of savings account.
    ##2. Display "Transactions" table with all transaction details:
    ##- Display header "Date": Date and time when transaction happened.
    ##- Display header "Category": What kind of transaction was made: Income, Misc etc
    ##- Display header "Description": Displays transaction id and type of Transaction
    ##- Display header "Amount": Displays the amount of made transaction
    ##- Display header "Balance": Displays balance amount, after each transaction
    ##3. If User has more than 1 checking accounts, only one of the accounts can be Activated:
    ##- Display ON/OFF toggle button on each Savings account
    ##- Display transaction history for a particular checking account if it is Activated(ON)