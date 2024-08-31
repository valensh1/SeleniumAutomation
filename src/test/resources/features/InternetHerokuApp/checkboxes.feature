Feature: User Login Tests

  Background:
    Given I navigate to the Checkboxes page
    Then I should be redirected to the Checkboxes page

  @Checkboxes @Smoke
  Scenario: Validate checkbox 1 is unchecked by default and can be checked and unchecked
    Then I verify checkbox 1 is unchecked
    When I click checkbox 1
    Then I verify checkbox 1 is checked
    When I click checkbox 1
    Then I verify checkbox 1 is unchecked

  @Checkboxes @Smoke
  Scenario: Validate functionality of both checkboxes
  """
1. Verify 1st checkbox is unchecked and 2nd checkbox is checked
2. Check checkbox 1
3. Uncheck checkbox 2
4.Validate checkbox 1 is checked and checkbox 2 is unchecked
    """
    Then I verify checkbox 1 is unchecked
    Then I verify checkbox 2 is checked
    When I click checkbox 1
    And I click checkbox 2
    Then I verify checkbox 1 is checked
    And I verify checkbox 2 is unchecked