import Api.AirlinesAPI;
import Api.AirportsAPI;
import Api.RoutesAPI;
import Utils.DataProcessor.DataProcessor;
import Types.Records.Airline;
import Types.Records.Airport;
import Types.Records.Route;
import Repositories.InMemoryAirlineRepository;
import Repositories.InMemoryAirportRepository;
import Repositories.InMemoryRouteRepository;
import Services.AirlineServiceImpl;
import Services.AirportServiceImpl;
import Services.RouteServiceImpl;
import Types.Interfaces.Services.AirlineService;
import Types.Interfaces.Services.AirportService;
import Types.Interfaces.Services.RouteService;
import Utils.Printer.DataPrinter;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        // Create API instances
        AirlinesAPI airlinesAPI = new AirlinesAPI("config.properties");
        AirportsAPI airportsAPI = new AirportsAPI("config.properties");
        RoutesAPI routesAPI = new RoutesAPI("config.properties");

        // Fetch data from APIs
        List<String[]> airlinesData = airlinesAPI.fetchAirlines();
        List<String[]> airportsData = airportsAPI.fetchAirports();
        List<String[]> routesData = routesAPI.fetchRoutes();

        // Process the data
        List<Airline> airlines = DataProcessor.processAirlinesData(airlinesData);
        List<Airport> airports = DataProcessor.processAirportData(airportsData);
        List<Route> routes = DataProcessor.processRouteData(routesData);

        // Initialize InMemory repositories
        InMemoryAirlineRepository airlineRepository = new InMemoryAirlineRepository();
        InMemoryAirportRepository airportRepository = new InMemoryAirportRepository();
        InMemoryRouteRepository routeRepository = new InMemoryRouteRepository();

        // Save the data using the service layer
        AirlineService airlineService = new AirlineServiceImpl(airlineRepository);
        AirportService airportService = new AirportServiceImpl(airportRepository);
        RouteService routeService = new RouteServiceImpl(routeRepository);

        airlineService.saveAirlines(airlines);
        airportService.saveAirports(airports);
        routeService.saveRoutes(routes);

        //Print the results
        DataPrinter dataPrinter = new DataPrinter();
        //dataPrinter.printAirlinesByCountry(airlineService.getAirlinesByCountry("United States"));
        dataPrinter.printDestinationsByAirlineName(airportService.getDestinationsByAirlineName("British Airways"));
        //dataPrinter.printDestinationsByAirlineCode(airportService.getDestinationsByAirlineCode(324));
    }
}


