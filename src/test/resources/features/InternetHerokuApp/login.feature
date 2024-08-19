Feature: User Login

  Background:
    Given I navigate to the Login page

  Scenario: Valid login
    When I enter valid username tomsmith
    And I enter a valid password SuperSecretPassword!
    And I click Login button
    Then I validate successful login message



