Feature: Homepage element visibility

  Scenario: Verify welcome banner, sell banner, and images visibility on the homepage
    Given I am on the homepage
    When I check if the welcome banner is visible
    And I check if the sell banner is visible
    And I check if the images are visible
    Then all homepage elements should be visible
