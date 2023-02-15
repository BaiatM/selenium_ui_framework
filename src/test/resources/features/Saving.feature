Feature: User is able to see all saving bank accounts
  Background: User is logged in
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @wip
  Scenario: User is able to create and see the saving account information
    Given user clicks on savings dropdown
    And user is able to see ViewSavings and NewSavings options
    When user clicks on New Savings option
    And user is directed to creating a new savings account page
    And user fills the page with related information
    When user clicks on submit button
    And user directed to ViewSavingsAccounts
    And user is able to see newly created savings account
    Then user verifies savings account information

  Scenario:




  Scenario:






  ### AllSavingsAccounts###
#>As a User,
#I want to have the ability to view all my Savings bank accounts
#so that I can manage my accounts and see account balance and transactions.

#Functionalities:
#1. After User creates a new savings account, user should be able to view savings account information.
###All information should match the entered values during the submission of savings account.
    # -asserting 4 things such as: account name, balance, ownership, account type
#2. Display "Transactions" table with all transaction details:
#- Display header "Date": Date and time when transaction happened.
#- Display header "Category": What kind of transaction was made: Income, Misc etc
#- Display header "Description": Displays transaction id and type of Transaction
#- Display header "Amount": Displays the amount of made transaction
#- Display header "Balance": Displays balance amount, after each transaction
#3. If User has more than 1 checking accounts, only one of the accounts can be Activated:
#- Display ON/OFF toggle button on each Savings account
#- Display transaction history for a particular checking account if it is Activated(ON)