package Utils.Types.Interfaces.Repositories;

import Utils.Types.Records.Airline;

import java.util.List;

public interface AirlineRepository {
    void save(List<Airline> airlines);

    List<Airline> findByCountry(String country);

    Airline findById(int id);
    int findIdByName(String name);

}
