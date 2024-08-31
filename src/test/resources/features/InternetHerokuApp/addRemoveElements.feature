Feature: Add/Remove Elements

  Background:
    Given I navigate to the Add/Remove Elements page
    Then I should be redirected to the Add/Remove Elements page

  @AddRemoveElements @Smoke
  Scenario Outline: Add elements and delete elements and validate how many elements still display
    When I click on Add Element button <addCount> times
    And I click on Delete button <deleteCount> times
    Then I validate number of buttons displayed

    Examples:
      | addCount | deleteCount |
      | 30       | 20          |
      | 50       | 25          |
      | 40       | 35          |
      | 10       | 5           |
      | 1        | 1           |

