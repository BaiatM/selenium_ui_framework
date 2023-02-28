Feature: Click message/email icon and manage messages

  Background: User logs in to Digital Bank
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on sign in button
    Then verify user is successfully logged in to the account
  @Smoke
  Scenario:
    Given user has clicked message-email navigation bar icon
    And has seen the number of messages in the icon's badge
    Then user should see on-screen message confirming the number of Unread Messages matches badge number