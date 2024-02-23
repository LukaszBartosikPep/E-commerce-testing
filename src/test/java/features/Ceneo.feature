Feature: Ceneo



  @Compare
  Scenario: Compare offers
    Given Ceneo is opened
    Then I search for product
    Then I select lowest prices
  @Colors
  Scenario: Compare different colors by price
    Given Ceneo is opened
    Then I search for product
    When I check prices by color
