package Backend.Repositories;

import Utils.Types.Records.Airline;
import Utils.Types.Interfaces.Repositories.AirlineRepository;

import java.util.*;

public class InMemoryAirlineRepository implements AirlineRepository {
    private Map<String, List<Airline>> airlinesByCountry = new HashMap<>();

    @Override
    public void save(List<Airline> airlinesList) {
        airlinesByCountry.clear();
        for (Airline airline : airlinesList) {
            airlinesByCountry.computeIfAbsent(airline.country(), k -> new ArrayList<>()).add(airline);
        }
    }

    @Override
    public List<Airline> findByCountry(String country) {
        return Collections.unmodifiableList(airlinesByCountry.getOrDefault(country, new ArrayList<>()));
    }

    @Override
    public Airline findById(int id) {
        for (List<Airline> airlines : airlinesByCountry.values()) {
            for (Airline airline : airlines) {
                if (airline.id() == id) {
                    return airline;
                }
            }
        }
        return null;
    }

    @Override
    public int findIdByName(String name) {
        for (List<Airline> airlines : airlinesByCountry.values()) {
            for (Airline airline : airlines) {
                if (airline.name().equals(name)) {
                    return airline.id();
                }
            }
        }
        return -1;
    }
}
