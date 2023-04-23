package Repositories;

import Types.Records.Airport;
import Types.Interfaces.Repositories.AirportRepository;

import java.util.*;

public class InMemoryAirportRepository implements AirportRepository {
    private Map<String, List<Airport>> destinationsByAirlineName = new HashMap<>();
    private Map<Integer, List<Airport>> destinationsByAirlineCode = new HashMap<>();

    @Override
    public void save(List<Airport> airportsList) {
        for (Airport airport : airportsList) {
            String airlineName = airport.name();
            int airlineCode = airport.id();

            destinationsByAirlineName.computeIfAbsent(airlineName, k -> new ArrayList<>()).add(airport);
            destinationsByAirlineCode.computeIfAbsent(airlineCode, k -> new ArrayList<>()).add(airport);
        }
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
