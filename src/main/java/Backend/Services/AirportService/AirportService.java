package Backend.Services.AirportService;

import Utils.Types.Records.Airport;
import Utils.Types.Interfaces.Repositories.AirportRepository;

import java.util.List;

public class AirportService implements Utils.Types.Interfaces.Services.AirportService {
    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
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
