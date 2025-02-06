package lldQuestions.airlineManagementSystemDesign.flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch {
    private List<Flight> flights;
    
    public FlightSearch(List<Flight>flights){
        this.flights=flights;
    }

    public List<Flight> searchFlights(String source,String destination,LocalDate date){
        List<Flight> searchResult=new ArrayList<>();
        for(Flight flight:flights){
            if(flight.getSource().equalsIgnoreCase(source) && 
               flight.getDestination().equalsIgnoreCase(destination) &&
               flight.getDepartureTime().toLocalDate().equals(date)){
                searchResult.add(flight);
               }
        }
        return searchResult;
    }
}
