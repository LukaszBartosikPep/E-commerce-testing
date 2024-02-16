Feature: Ceneo



  @Compare
  Scenario: Compare offers
    Given Ceneo is opened
    Then I search for product
    Then I select lowest prices