Feature: User Login

  Background:
    Given I navigate to the Login page
    Then I should be redirected to the Login page

  @Login
  Scenario: Valid login
    When I enter username tomsmith
    And I enter password SuperSecretPassword!
    And I click Login button
    Then I verify valid login message
      | valid message | You logged into a secure area! |
    When I click Logout button
    Then I verify logout message
      | logout message | You logged out of the secure area! |

  @Login
  Scenario: Invalid login - Invalid username
    When I enter username svalentine
    And I enter password SuperSecretPassword!
    And I click Login button
    Then I verify invalid login message
      | invalid message | Your username is invalid! |

  @Login
  Scenario: Invalid login - Invalid password
    When I enter username tomsmith
    And I enter password SuperSecretPassword!!
    And I click Login button
    Then I verify invalid login message
      | invalid message | Your password is invalid! |