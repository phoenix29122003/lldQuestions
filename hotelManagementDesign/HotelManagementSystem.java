package lldQuestions.hotelManagementDesign;

import java.util.Map;
import java.util.UUID;

import lldQuestions.hotelManagementDesign.payment.Payment;

import java.time.LocalDate;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;

public class HotelManagementSystem {
    private Map<String,Guest>guests;
    private Map<String,Room>rooms;
    private Map<String,Reservation>reservations;

    public HotelManagementSystem(){
        this.guests=new HashMap<>();
        this.rooms=new HashMap<>();
        this.reservations=new HashMap<>();
    }

    public void addGuest(Guest guest){
        guests.put(guest.getId(),guest);
    }

    public Guest getGuest(String guestId){
        return guests.get(guestId);
    }

    public void addRoom(Room room){
        rooms.put(room.getId(),room);
    }

    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }

    public Reservation bookRoom(Guest guest,Room room,LocalDate checkInDate,LocalDate chechOutDate){
        if(room.getStatus()==RoomStatus.AVAILABLE){
            room.book();
            String reservationId=generateReservationId();
            Reservation reservation=new Reservation(reservationId, guest, room, checkInDate, chechOutDate);
            reservations.put(reservationId,reservation);
            return reservation;
        }
        return null;
    }

    public void cancelReservation(String reservationId){
        Reservation reservation=reservations.get(reservationId);
        if(reservation!=null){
            reservation.cancel();
            reservations.remove(reservationId);
        }
    }

    public void checkIn(String reservationId){
        Reservation reservation=reservations.get(reservationId);
        if(reservation!=null && reservation.getReservationStatus()==ReservationStatus.CONFIRMED){
            reservation.getRoom().checkIn();
        }
        else{
            System.out.println("Invalid Reservation.");
        }
    }

    public void checkOut(String reservationId,Payment payment){
        Reservation reservation=reservations.get(reservationId);
        if(reservation!=null && reservation.getReservationStatus()==ReservationStatus.CONFIRMED){
            Room room=reservation.getRoom();
            double payableAmount=room.getPrice()*ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            if(payment.processPayment(payableAmount)){
                room.checkOut();
                reservations.remove(reservationId);
            }
            else{
                System.out.println("Payment failed.");
            }
        }
        else{
            System.out.println("Invalid reservation");
        }
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
