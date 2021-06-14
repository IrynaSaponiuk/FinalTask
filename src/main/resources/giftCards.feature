Feature: Gift Cards
  As a user
  I want to check how to order eGift Card
  So that I can be sure that ordering gift cards is working correctly

  Scenario Outline: Check ordering of Gift Card
    Given User opens '<homePage>' page
    And User clicks on Deliver to button
    And User changes country to deliver
    And User clicks on Gift Cards button
    And User clicks on eGift button
    When User enters all information to order eGift Card and checks the visibility of elements on page
    Then User checks that his eGift Card is added to Cart




    Examples:
      | homePage                |
      | https://www.amazon.com/|