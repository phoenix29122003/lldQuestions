package lldQuestions.airlineManagementSystemDesign;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lldQuestions.airlineManagementSystemDesign.booking.Booking;
import lldQuestions.airlineManagementSystemDesign.booking.BookingManager;
import lldQuestions.airlineManagementSystemDesign.flight.Flight;
import lldQuestions.airlineManagementSystemDesign.flight.FlightSearch;
import lldQuestions.airlineManagementSystemDesign.payment.Payment;
import lldQuestions.airlineManagementSystemDesign.payment.PaymentProcessor;
import lldQuestions.airlineManagementSystemDesign.seat.Seat;

public class AirlineManagementSystem {
    private List<Flight>flights;
    private List<Aircraft>aircrafts;
    private FlightSearch flightSearch;
    private BookingManager bookingManager;
    private PaymentProcessor paymentProcessor;

    public AirlineManagementSystem(){
        this.flights=new ArrayList<>();
        this.aircrafts=new ArrayList<>();
        this.flightSearch=new FlightSearch(flights);
        this.paymentProcessor=new PaymentProcessor();
        this.bookingManager=new BookingManager();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlights(source, destination, date);
    }

    public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price) {
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }
}
