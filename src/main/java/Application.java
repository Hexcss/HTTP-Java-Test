import Backend.Api.AirlinesAPI;
import Backend.Api.AirportsAPI;
import Backend.Api.RoutesAPI;
import Backend.Utils.DataProcessor.DataProcessor;
import Frontend.GUI.ConsoleGUI;
import Frontend.Loader.Loader;
import Utils.Types.Records.Airline;
import Utils.Types.Records.Airport;
import Utils.Types.Records.Route;
import Backend.Repositories.InMemoryAirlineRepository;
import Backend.Repositories.InMemoryAirportRepository;
import Backend.Repositories.InMemoryRouteRepository;
import Backend.Services.AirlineServiceImpl;
import Backend.Services.AirportServiceImpl;
import Backend.Services.RouteServiceImpl;
import Utils.Types.Interfaces.Services.AirlineService;
import Utils.Types.Interfaces.Services.AirportService;
import Utils.Types.Interfaces.Services.RouteService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        // Start the loader animation
        Loader loader = new Loader();
        Thread loaderThread = new Thread(loader);
        loaderThread.start();

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
        InMemoryRouteRepository routeRepository = new InMemoryRouteRepository();
        InMemoryAirportRepository airportRepository = new InMemoryAirportRepository(airlineRepository, routeRepository);


        // Save the data using the service layer
        AirlineService airlineService = new AirlineServiceImpl(airlineRepository);
        AirportService airportService = new AirportServiceImpl(airportRepository);
        RouteService routeService = new RouteServiceImpl(routeRepository);

        airlineService.saveAirlines(airlines);
        airportService.saveAirports(airports);
        routeService.saveRoutes(routes);

        // Stop the loader animation and start the GUI
        loader.stopLoading();
        try {
            loaderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\rPreparing flight data... done.\033[0m");
        ConsoleGUI consoleGUI = new ConsoleGUI(airlineService, airportService, routeService);
        consoleGUI.run();
    }
}


