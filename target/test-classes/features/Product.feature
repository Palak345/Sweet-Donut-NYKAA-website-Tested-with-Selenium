Feature: Product visibility, category selection, and price visibility on the e-commerce page

  Scenario: Verify all products are visible, category is selected, sorting is applied, and prices are visible
    Given I am on the product page
    When I check if all products are visible
    And I select the "Electronics" category
    And I apply the "Price: Low to High" sorting option
    Then all prices should be visible for the products
