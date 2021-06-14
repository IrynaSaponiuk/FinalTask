Feature: addToCart
  As a user
  I want to check how comparing function and deleting function work on the addToCart page
  So that I can be sure that I can make both actions and it will work correctly

  Scenario Outline: Check comparing function with other items in cart
    Given User opens '<homePage>' page
    And User clicks on Menu button
    And User clicks on Arts and crafts button in Menu
    And User clicks on Painting, drawing and Art supplies button
    And User clicks on the first product on Page
    And User adds product to Cart
    When User goes to Cart
    And User clicks on comparing button in cart
    Then User checks the visibility of other products in comparing window

    Examples:
      | homePage                |
      | https://www.amazon.com/|


    Scenario Outline: Check deleting product from the cart
      Given User opens '<homePage>' page
      And User clicks on Menu button
      And User clicks on Arts and crafts button in Menu
      And User clicks on Painting, drawing and Art supplies button
      And User clicks on the first product on Page
      And User adds product to Cart
      When User goes to Cart
      And User clicks on delete button
      Then User checks that there are no products in the Cart

      Examples:
        | homePage                |
        | https://www.amazon.com/|