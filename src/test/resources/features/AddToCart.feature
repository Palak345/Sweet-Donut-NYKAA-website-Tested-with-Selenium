Feature: Add Product to Cart

  Scenario: Add a product to the cart
    Given I open the Nykaa demo website
    When I search for "Lipstick"
    And I add the first product to the cart
    Then I should see the product in the cart
