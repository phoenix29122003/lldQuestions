package lldQuestions.airlineManagementSystemDesign.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import lldQuestions.airlineManagementSystemDesign.Passenger;
import lldQuestions.airlineManagementSystemDesign.flight.Flight;
import lldQuestions.airlineManagementSystemDesign.seat.Seat;

public class BookingManager {
    private Map<String,Booking>bookings;
    private final AtomicInteger bookingCounter = new AtomicInteger(0);

    public BookingManager(){
        this.bookings=new HashMap<>();
    }

    public Booking createBooking(Flight flight,Passenger passenger,Seat seat,double price){
        String bookingNumber=generateBookingNumber();
        Booking booking=new Booking(bookingNumber, flight, passenger, seat, price);
        bookings.put(bookingNumber,booking);
        return booking;
    }

    public void cancelBooking(String bookingNumber){
        Booking booking=bookings.get(bookingNumber);
        if(booking!=null){
            booking.cancel();
        }
    }

    private String generateBookingNumber() {
        int bookingId = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "BKG" + timestamp + String.format("%06d", bookingId);
    }
}
