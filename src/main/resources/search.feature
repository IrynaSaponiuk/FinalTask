Feature: Search
  As a user
  I want to check how search function is working
  So that I can be sure that this function works correctly

  Scenario Outline: Check if URL contains keyword
    Given User opens '<homePage>' page
    When User types keyword in search field
    Then User checks that current URL contains his keyword


    Examples:
      | homePage                |
      | https://www.amazon.com/|

  Scenario Outline: Check ascendant order of price on search page
    Given User opens '<homePage>' page
    When User types keyword in search field
    And User chooses ascendant order of price on the page
    Then User checks that all prices are in ascendant order


    Examples:
      | homePage                |
      | https://www.amazon.com/|