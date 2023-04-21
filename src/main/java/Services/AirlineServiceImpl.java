package Services;

import Records.Airline;
import Utils.Interfaces.Repositories.AirlineRepository;
import Utils.Interfaces.Services.AirlineService;

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
