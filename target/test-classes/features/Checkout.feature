Feature: Checkout Process

  Scenario: Proceed to checkout
    Given I have a product in the cart
    When I proceed to checkout
    Then I should see the payment page
