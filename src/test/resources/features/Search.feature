Feature: Search Functionality

  Scenario: Search for a product
    Given I open the Nykaa demo website
    When I search for "Lipstick"
    Then I should see relevant search results
