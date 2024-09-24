package RestfulBooker;

import lombok.Data;

@Data
public class BookingsPOJO {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public BookingsPOJO(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout, String additionalNeeds) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositpaid = depositPaid;
        this.bookingdates = new BookingDates(checkin,checkout);
        this.additionalneeds = additionalNeeds;
    }

    public record BookingDates(String checkin, String checkout) {};
}
