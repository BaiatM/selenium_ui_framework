Feature: SignUp feature
  @Smoke
  Scenario: User is able to sign up with fake credentials
    Given user clicks on sign up button
    And user fills the form
    When user clicks the next button
    And user fills the form for the second page
    And user clicks the register button

