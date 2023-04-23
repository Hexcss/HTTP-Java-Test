package Types.Interfaces.Repositories;

import Types.Records.Airport;

import java.util.List;

public interface AirportRepository {
    void save(List<Airport> airports);

    List<Airport> findByAirlineName(String airlineName);

    List<Airport> findByAirlineCode(int airlineCode);
}