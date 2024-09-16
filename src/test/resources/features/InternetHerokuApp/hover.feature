Feature: Hover Page Tests

  Background:
    Given I navigate to the Hovers page
    Then I should be redirected to the Hovers page
      | title           | Hovers                                          |
      | hover page text | Hover over the image for additional information |

  @Hover @Smoke
  Scenario: Verify that hovering over each user image reveals the hidden information
    When I hover over image 1
    Then I verify image 1 text and profile link displays
    When I hover over image 2
    Then I verify image 2 text and profile link displays
    When I hover over image 3
    Then I verify image 3 text and profile link displays

  @Hover @Smoke
  Scenario Outline: Verify that clicking on link upon hover takes user to profile page
    When I hover over image <image_number>
    Then I verify image <image_number> text and profile link displays
    When I click on View profile link of image <image_number>
    Then I verify I am redirected to correct URL address of image <image_number>
    Examples:
      | image_number |
      | 1            |
      | 2            |
      | 3            |
