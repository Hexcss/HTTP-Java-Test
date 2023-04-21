package Repositories;

import Records.Airport;
import Utils.Interfaces.Repositories.AirportRepository;

import java.util.*;

public class InMemoryAirportRepository implements AirportRepository {
    private Map<String, List<Airport>> destinationsByAirlineName = new HashMap<>();
    private Map<Integer, List<Airport>> destinationsByAirlineCode = new HashMap<>();

    @Override
    public void save(List<Airport> airportsList) {
        // You can also move the setAirports method's logic from the original class to here
    }

    @Override
    public List<Airport> findByAirlineName(String airlineName) {
        return Collections.unmodifiableList(destinationsByAirlineName.getOrDefault(airlineName, new ArrayList<>()));
    }

    @Override
    public List<Airport> findByAirlineCode(int airlineCode) {
        return Collections.unmodifiableList(destinationsByAirlineCode.getOrDefault(airlineCode, new ArrayList<>()));
    }
}
