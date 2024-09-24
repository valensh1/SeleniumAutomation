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
            makeAPICall(requestType.toUpperCase(), json);
    }

    public String convertToJson(BookingsPOJO object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    public void makeAPICall(String requestType, String json) {
        switch(requestType) {
            case "POST" -> {
                response = given()
                        .contentType("application/json")
                        .body(json)
                        .request(requestType, "/booking");
                bookingID = response.jsonPath().getInt("bookingid");
                System.out.println("This is my POST request response -> " + response.getBody().asString());
            }
            case "PUT" -> {
                response = given()
                        .contentType("application/json")
                        .body(json)
                        .accept("application/json")
                        .header("Cookie", "token=" + token)
                        .request(requestType, "/booking/" + bookingID);
                System.out.println("This is my PUT request response -> " + response.getBody().asString());
            }
            case "GET" -> {
                response = given()
                        .contentType("application/json")
                        .request(requestType, "/booking/" + bookingID);
                System.out.println("This is my GET request response -> " + response.getBody().asString());
            }
        }
    }

    public void getToken() {
        JSONObject tokenJSON = new JSONObject();
        tokenJSON.put("username", "admin");
        tokenJSON.put("password", "password123");
        Response response = given()
                .contentType("application/json")
                .body(tokenJSON.toString())
                .request("POST", "/auth");
        assertThat(response.getStatusCode()).isEqualTo(200);
        token = response.jsonPath().getString("token");
    }

    public void validateResponseCode(int expectedResponseCode) {
        assertThat(response.getStatusCode()).isEqualTo(expectedResponseCode);
    }

    public void validateBookingID() {
        assertThat(bookingID).isGreaterThan(0);
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