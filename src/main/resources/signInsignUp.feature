Feature: Sign In & Sign Up
  As a user
  I want to check sign in and sign up functionality
  So that I can be sure that this functions work correctly

  Scenario Outline: Check the visibility of all elements for signUp
    Given User opens '<homePage>' page
    And User clicks on Sign In field
    And User clicks on Create Account button
    When User enters all his information to register in certain fields
    Then User checks that all these fields are visible
    And User clicks on Continue button

    Examples:
      | homePage                |
      | https://www.amazon.com/|

  Scenario Outline: Check the visibility of all elements for signIn
    Given User opens '<homePage>' page
    And User clicks on Sign In field
    When User checks the visibility of email field and continue on page
    And User enters his email in email field and clicks on continue
    And User checks the visibility of password field and sign in button
    Then User enters his password and clicks on sign in button

    Examples:
      | homePage                |
      | https://www.amazon.com/|