Feature: Dropdown Page Tests

  Background:
    Given I navigate to the Dropdown page
    Then I should be redirected to the Dropdown page
      | title               | Dropdown List           |
      | default menu option | Please select an option |

  @Dropdown @Smoke
  Scenario: Validate a user can select both options from the dropdown menu, refresh page and then verify page resets
    When I select Option 1 from the dropdown menu
    Then I verify dropdown displays my selection
    When I select Option 2 from the dropdown menu
    Then I verify dropdown displays my selection
    When I refresh the page
    Then I verify dropdown resets to default option
      | default menu option | Please select an option |