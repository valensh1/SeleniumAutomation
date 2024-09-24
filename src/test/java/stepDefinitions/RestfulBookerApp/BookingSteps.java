package stepDefinitions.RestfulBookerApp;

import RestfulBooker.Bookings;
import io.cucumber.java8.En;

public class BookingSteps implements En {
    Bookings bookings = new Bookings();

    public BookingSteps() {
        When("^I get response for book with id of (.+)$", (String bookNumber) -> {
            bookings.getSingleBook(bookNumber);
        });

        When("^I create a booking using a POST request with the following information (\\w+) (\\w+) (\\d+) (true|false) (\\d{4}-\\d{2}-\\d{2}) (\\d{4}-\\d{2}-\\d{2}) (.+)$", (String firstName, String lastName, String price, String depositPaid, String checkinDate, String checkoutDate, String additionalNeeds)  -> {
            bookings.createBooking("POST", firstName, lastName, Integer.parseInt(price), Boolean.parseBoolean(depositPaid), checkinDate, checkoutDate, additionalNeeds);
        });

        Then("^I validate the response code of (.+)$", (String responseCode)  -> {
            bookings.validateResponseCode(Integer.parseInt(responseCode));
        });

        Then("^I validate that I received my booking ID$", ()  -> {
            bookings.validateBookingID();
        });

        When("^I make a GET request using my booking ID$", ()  -> {
            bookings.makeAPICall("GET", "");
        });

        Then("^I validate that my booking is correct$", ()  -> {
            bookings.validateBooking();
        });

        When("^I get a user token$", ()  -> {
            bookings.getToken();
        });

        Then("^I make an update to a booking using a PUT request (\\w+) (\\w+) (\\d+) (true|false) (\\d{4}-\\d{2}-\\d{2}) (\\d{4}-\\d{2}-\\d{2}) (.+)$", (String firstName, String lastName, String price, String depositPaid, String checkinDate, String checkoutDate, String additionalNeeds)  -> {
            bookings.createBooking("PUT", firstName, lastName, Integer.parseInt(price), Boolean.parseBoolean(depositPaid), checkinDate, checkoutDate, additionalNeeds);
        });




    }
}
