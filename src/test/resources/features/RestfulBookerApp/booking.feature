Feature: API Tests

  @API @smv
  Scenario Outline: Create a booking, verify the response code and booking ID, then retrieve the booking to confirm the correct data
    When I create a booking using a POST request with the following information <firstName> <lastName> <totalPrice> <depositPaid> <checkInDate> <checkoutDate> <additionalNeeds>
    Then I validate the response code of 200
    And I validate that I received my booking ID
    When I make a GET request using my booking ID
    Then I validate that my booking is correct
    Examples:
      | firstName | lastName | totalPrice | depositPaid | checkInDate | checkoutDate | additionalNeeds  |
      | Justin    | Herbert  | 249        | true        | 2024-10-01  | 2024-10-07   | 2 queen beds     |
#      | Joey      | Bosa     | 350        | false       | 2024-11-01  | 2024-11-15   | No smoking rooms |

  @API @smv
  Scenario Outline: Validate user is able to update booking with PUT request
    When I get a user token
    And I make an update to a booking using a PUT request <firstName> <lastName> <totalPrice> <depositPaid> <checkInDate> <checkoutDate> <additionalNeeds>
    Then I validate the response code of 200
    When I make a GET request using my booking ID
    Then I validate that my booking is correct
    Examples:
      | firstName | lastName | totalPrice | depositPaid | checkInDate | checkoutDate | additionalNeeds    |
      | Phil      | Rivers   | 17         | true        | 2024-12-01  | 2024-12-25   | Pool area reserved |
