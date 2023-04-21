package Utils.Interfaces.Services;

import Records.Airline;

import java.util.List;

public interface AirlineService {
    void saveAirlines(List<Airline> airlines);

    List<Airline> getAirlinesByCountry(String country);

    Airline getAirlineById(int id);
}
