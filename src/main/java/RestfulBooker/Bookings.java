package RestfulBooker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class Bookings {
    private BookingsPOJO bookingsPOJO;
    private Response response;
    private static int bookingID;
    private String token;

    public Bookings() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    public void getSingleBook(String bookNum) throws JsonProcessingException {
        Response response = given().get("/booking/" + bookNum);
        int responseCode = response.getStatusCode();
        System.out.println("This is the response code -> " + response.getStatusCode());
        System.out.println("This is the response body -> " + response.getBody().asString());
        given()
                .get("/booking")
                .then()
                .statusCode(200)  // Verify the status code is 200
                .body("size()", greaterThan(0));  // Check that the response contains at least one booking
        assertThat(responseCode).isEqualTo(200);
        BookingsPOJO bookingsPOJO = new BookingsPOJO("Justin", "Herbert", 10, false, "11/15/2025", "11/30/2025", "2 beds");
        System.out.println(bookingsPOJO.getFirstname());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(bookingsPOJO);
        System.out.println("This is the bookings object " + json);
        System.out.println("This is the lombok print -> " + bookingsPOJO);
    }

    public void createBooking(String requestType, String firstName, String lastName, int price, boolean depositPaid, String checkin, String checkout, String needs) throws JsonProcessingException {
        bookingsPOJO = new BookingsPOJO(firstName, lastName, price, depositPaid, checkin, checkout, needs);
        String json = convertToJson(bookingsPOJO);
        if (requestType.equalsIgnoreCase("POST")) {
            postRequest(json);
        } else {
            putRequest(json);
        }
    }

    public String convertToJson(BookingsPOJO object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    public void postRequest(String json) {
        System.out.println("This is the json being sent " + json);
        response = given()
                .contentType("application/json")
                .body(json)
                .request("POST", "/booking");
        System.out.println("This is the response " + response.getBody().asString());
        bookingID = response.jsonPath().getInt("bookingid");
    }

    public void getToken() {
        JSONObject tokenJSON = new JSONObject();
        tokenJSON.put("username", "admin");
        tokenJSON.put("password", "password123");
        System.out.println("This is the token JSON " + tokenJSON.toString());
        Response response = given()
                .contentType("application/json")
                .body(tokenJSON.toString())
                .request("POST", "/auth");
        assertThat(response.getStatusCode()).isEqualTo(200);
        token = response.jsonPath().getString("token");
        System.out.println("This is my token -> " + token);
    }

    public void putRequest(String json) {
        System.out.println("This is the PUT request with Booking ID -> " + json + " booking ID -> " + bookingID);
        System.out.println("This is my token I am trying to use in my PUT request --> " + token);
        response = given()
                .contentType("application/json")
                .body(json)
                .accept("application/json")
                .header("Cookie", "token=" + token)
                .request("PUT", "/booking/" + bookingID);
        System.out.println("This is the PUT request response -> " + response.getBody().asString());
        System.out.println("This is the status code response -> " + response.getStatusCode());
    }

    public void validateResponseCode(int expectedResponseCode) {
        assertThat(response.getStatusCode()).isEqualTo(expectedResponseCode);
    }

    public void validateBookingID() {
        assertThat(bookingID).isGreaterThan(0);
    }

    public void getBooking() {
        response = given()
                .contentType("application/json")
                .request("GET", "/booking/" + bookingID);
        System.out.println("This is the booking response to validate for the booking I just created " + response.getBody().asString());
    }

    public void validateBooking() {
        BookingsPOJO responseObject = new BookingsPOJO(
                response.jsonPath().getString("firstname"),
                response.jsonPath().getString("lastname"),
                response.jsonPath().getInt("totalprice"),
                response.jsonPath().getBoolean("depositpaid"),
                response.jsonPath().getString("bookingdates.checkin"),
                response.jsonPath().getString("bookingdates.checkout"),
                response.jsonPath().getString("additionalneeds")
        );
        assertThat(responseObject).isEqualTo(bookingsPOJO);
    }
}