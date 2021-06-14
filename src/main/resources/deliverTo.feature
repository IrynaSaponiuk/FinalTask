Feature: Deliver To
  As a user
  I want to check how to change the country to deliver
  So that I can be  sure that this function works correctly

  Scenario Outline: Change the country to deliver
    Given User opens '<homePage>' page
    And User clicks on Deliver to button
    When User changes country to deliver
    Then User checks that his country to deliver is visible


    Examples:
      | homePage                |
      | https://www.amazon.com/|