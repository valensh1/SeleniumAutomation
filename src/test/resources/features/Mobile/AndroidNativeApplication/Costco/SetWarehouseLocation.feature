Feature: Set Warehouse Location Feature

  @Android @smv
  Scenario: User successfully sets the warehouse location
    Given I am on the Warehouses search page
    When I enter city of San Juan Capistrano
    Then I verify filtered city search result
    When I tap on city from search results
    And I find my warehouse from list
    And I tap on Set as My Warehouse button
    And I tap on Continue button
    Then I verify my set warehouse displays on home page
    When I navigate to Warehouse page
    Then I verify my set warehouse displays on Warehouse page