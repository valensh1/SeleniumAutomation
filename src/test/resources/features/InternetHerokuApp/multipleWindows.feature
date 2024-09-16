Feature: Multiple Windows tests

  Background:
    Given I navigate to the Multiple Windows page
    Then I should be redirected to the Multiple Windows page
      | title | Opening a new window |

  @Windows @Smoke
  Scenario: Click to open a new window and validate text in new window
    When I click on Click Here link
    Then I validate that a new window opens with url
      | URL | windows/new |
    And I validate text in new open window
      | title | New Window |
    When I switch to original window
    And I close current window
    And I close remaining windows

  @Windows @Smoke
  Scenario Outline: Validate number of open windows
    When I click on Click Here link <clicks> times
    Then I validate the number of open windows

    Examples:
      | clicks |
      | 0      |
      | 1      |
      | 10     |
      | 20     |
