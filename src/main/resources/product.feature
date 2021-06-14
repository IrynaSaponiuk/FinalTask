Feature: Product
  As a user
  I want to check how price selection is working and how to choose products by parameter in the menu on the side
  So that I can be  sure that this functions work correctly

  Scenario Outline: Check if price selection is correct
    Given User opens '<homePage>' page
    And User clicks on Menu button
    And User clicks on Electronics button
    And User clicks on Headphones button
    When User sets certain price parameter
    Then User checks that all prices on the page are less than certain price he chose


    Examples:
      | homePage                |
      | https://www.amazon.com/|

  Scenario Outline: Check if all names of products contain chosen parameter
    Given User opens '<homePage>' page
    And User clicks on Menu button
    And User clicks on Computers button
    And User clicks on Monitors button
    When User selects parameter HP
    Then User checks that all names of products contain chosen parameter


    Examples:
      | homePage                |
      | https://www.amazon.com/|