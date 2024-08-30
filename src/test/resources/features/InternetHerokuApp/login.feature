#@smv
Feature: User Login Tests

  Background:
    Given I navigate to the Login page
    Then I should be redirected to the Login page

  @Login @Smoke
  Scenario: Valid login
    When I enter username tomsmith
    And I enter password SuperSecretPassword!
    And I click on Login button
    Then I verify valid login message
      | valid message | You logged into a secure area! |
    When I click on Logout button
    Then I verify logout message
      | logout message | You logged out of the secure area! |

  @Login @Smoke
  Scenario: Invalid login - Invalid username
    When I enter username svalentine
    And I enter password SuperSecretPassword!
    And I click on Login button
    Then I verify invalid login message
      | invalid message | Your username is invalid! |

  @Login @Smoke
  Scenario: Invalid login - Invalid password
    When I enter username tomsmith
    And I enter password SuperSecretPassword!!
    And I click on Login button
    Then I verify invalid login message
      | invalid message | Your password is invalid! |