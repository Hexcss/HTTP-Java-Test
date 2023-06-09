package Utils.Types.Interfaces.Services;

import Utils.Types.Records.Airline;

import java.util.List;

public interface AirlineService {
    void saveAirlines(List<Airline> airlines);

    List<Airline> getAirlinesByCountry(String country);

    Airline getAirlineById(int id);

    int findIdByName (String airlineName);
}
