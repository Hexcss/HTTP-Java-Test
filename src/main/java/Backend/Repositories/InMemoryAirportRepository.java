package Backend.Repositories;

import Utils.Types.Interfaces.Repositories.AirlineRepository;
import Utils.Types.Interfaces.Repositories.RouteRepository;
import Utils.Types.Records.Airport;
import Utils.Types.Interfaces.Repositories.AirportRepository;
import Utils.Types.Records.Route;

import java.util.*;

public class InMemoryAirportRepository implements AirportRepository {
    private final AirlineRepository airlineRepository;
    private final RouteRepository routeRepository;
    private final Map<Integer, Airport> airportsById = new HashMap<>();

    public InMemoryAirportRepository(AirlineRepository airlineRepository, RouteRepository routeRepository) {
        this.airlineRepository = airlineRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public void save(List<Airport> airportsList) {
        for (Airport airport : airportsList) {
            airportsById.put(airport.id(), airport);
        }
    }

    @Override
    public List<Airport> findByAirlineName(String airlineName) {
        int airlineId = airlineRepository.findIdByName(airlineName);
        return findDestinationsByAirlineId(airlineId);
    }

    @Override
    public List<Airport> findByAirlineCode(int airlineCode) {
        return findDestinationsByAirlineId(airlineCode);
    }

    private List<Airport> findDestinationsByAirlineId(int airlineId) {
        List<Airport> destinations = new ArrayList<>();
        List<Route> routes = routeRepository.findByAirlineId(airlineId);
        for (Route route : routes) {
            Airport destinationAirport = airportsById.get(route.destinationAirportId());
            if (destinationAirport != null) {
                destinations.add(destinationAirport);
            }
        }
        return Collections.unmodifiableList(destinations);
    }
}
