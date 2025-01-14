package lldQuestions.carRentalSystemDesign;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public Reservation(String reservationId,Customer customer,Car car,LocalDate startDate,LocalDate endDate){
        this.reservationId=reservationId;
        this.customer=customer;
        this.car=car;
        this.startDate=startDate;
        this.endDate=endDate;
        this.totalPrice=calculateTotalPrice();
    }

    private double calculateTotalPrice(){
        return (ChronoUnit.DAYS.between(startDate, endDate) + 1)*car.getRentalPricePerDay();
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public Car getCar(){
        return car;
    }

    public String getReservationId(){
        return reservationId;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public Customer getCustomer(){
        return customer;
    }
}
