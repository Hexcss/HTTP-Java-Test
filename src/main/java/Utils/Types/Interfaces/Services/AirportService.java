package Utils.Types.Interfaces.Services;

import Utils.Types.Records.Airport;

import java.util.List;

public interface AirportService {
    void saveAirports(List<Airport> airports);

    List<Airport> getDestinationsByAirlineName(String airlineName);

    List<Airport> getDestinationsByAirlineCode(int airlineCode);

}
