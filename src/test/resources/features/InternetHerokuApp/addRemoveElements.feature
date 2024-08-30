Feature: Add/Remove Elements

  Background:
    Given I navigate to the Add/Remove Elements page
    Then I should be redirected to the Add/Remove Elements page

  @smv
  Scenario:
    When I click on Add Element button 42 times
    And I click on Delete button 42 times
    Then I validate number of buttons displayed


