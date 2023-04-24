package Backend.Services.AirportService;

import Utils.Types.Records.Airport;
import Utils.Types.Interfaces.Repositories.AirportRepository;
import Utils.Types.Interfaces.Services.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public void saveAirports(List<Airport> airports) {
        airportRepository.save(airports);
    }

    @Override
    public List<Airport> getDestinationsByAirlineName(String airlineName) {
        return airportRepository.findByAirlineName(airlineName);
    }

    @Override
    public List<Airport> getDestinationsByAirlineCode(int airlineCode) {
        return airportRepository.findByAirlineCode(airlineCode);
    }
}
