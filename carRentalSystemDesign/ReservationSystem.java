package lldQuestions.carRentalSystemDesign;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationSystem {
    private Map<String,Car>cars;
    private Map<String,Reservation>reservations;
    private PaymentProcessor paymentProcessor;

    public ReservationSystem(){
        this.cars=new HashMap<>();
        this.reservations=new HashMap<>();
        this.paymentProcessor=new CreditCardPaymentProcess();
    }

    public void addCar(Car car){
        cars.put(car.getLicensePlate(),car);
    }

    public void removeCar(String licensePlate){
        cars.remove(licensePlate);
    }

    public List<Car> searchCar(String make,String model,LocalDate startDate,LocalDate endDate){
        List<Car> availableCars=new ArrayList<>();
        for(Car car:cars.values()){
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()==true){
                if(ifCarAvailable(car,startDate,endDate)){
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean ifCarAvailable(Car car,LocalDate startDate,LocalDate endDate){
        for(Reservation reservation:reservations.values()){
            if(reservation.getCar().equals(car)){
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public Reservation makeReservation(Customer customer,Car car,LocalDate startDate,LocalDate endDate){
        if(ifCarAvailable(car, startDate, endDate)){
            String reservationId=generateReservationId();
            Reservation reservation=new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId,reservation);
            car.setAvailability(false);
            return reservation;
        }
        return null;
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getCar().setAvailability(true);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }
}
