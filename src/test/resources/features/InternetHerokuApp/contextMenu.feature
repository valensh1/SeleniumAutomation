Feature: Hover Page Tests

  Background:
    Given I navigate to the Context Menu page
    Then I should be redirected to the Context Menu page
      | title       | Context Menu                                                                                                          |
      | paragraph 1 | Context menu items are custom additions that appear in the right-click menu.                                          |
      | paragraph 2 | Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert. |

  @ContextMenu
  Scenario: Right click on box and validate Javascript alert
    When I right-click on hot spot
    Then I verify alert message text
      | alert message | You selected a context menu |
    And I click OK button to close alert message
