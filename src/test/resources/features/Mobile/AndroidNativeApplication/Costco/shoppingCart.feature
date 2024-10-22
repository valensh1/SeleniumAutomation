Feature: Shopping Cart

  Background: Setting Warehouse upon logging into application
    Given I am on the Warehouses search page
    When I enter city of San Juan Capistrano
    Then I verify filtered city search result
    When I tap on city from search results
    And I find my warehouse from list
    And I tap on Set as My Warehouse button
    And I tap on Continue button

  @Android @smv
  Scenario Outline: Validate adding an item to shopping cart
    When I navigate to Shop page on mobile app
    And I tap on <Department> department
    And I tap on <Categories> from categories list
    And I tap on <SubCategory> from subcategories list
    And I tap Add button on the Shop page
    Examples:
      | Department       | Categories | SubCategory  |
      | Sports & Fitness | Game Room  | Table Tennis |
#      | Patio, Lawn & Garden | Patio & Outdoor Furniture | Outdoor Patio Fire Pit Sets |
