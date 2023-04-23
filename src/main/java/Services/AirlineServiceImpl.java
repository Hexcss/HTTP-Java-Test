package Services;

import Types.Records.Airline;
import Types.Interfaces.Repositories.AirlineRepository;
import Types.Interfaces.Services.AirlineService;

import java.util.List;

public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository) {
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
}
