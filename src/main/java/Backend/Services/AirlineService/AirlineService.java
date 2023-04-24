package Backend.Services.AirlineService;

import Utils.Types.Records.Airline;
import Utils.Types.Interfaces.Repositories.AirlineRepository;

import java.util.List;

public class AirlineService implements Utils.Types.Interfaces.Services.AirlineService {
    private AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public void saveAirlines(List<Airline> airlines) {
        airlineRepository.save(airlines);
    }

    @Override
    public List<Airline> getAirlinesByCountry(String country) {
        return airlineRepository.findByCountry(country);
    }

    @Override
    public Airline getAirlineById(int id) {
        return airlineRepository.findById(id);
    }

    @Override
    public int findIdByName (String airlineName) {
        return airlineRepository.findIdByName(airlineName);
    }
}
