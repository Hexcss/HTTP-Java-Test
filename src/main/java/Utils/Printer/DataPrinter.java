package Utils.Printer;

import Records.Airline;
import Records.Airport;
import Records.Route;

import java.util.List;

/**
 * Class responsible for printing CSV data.
 */
public class DataPrinter {

    /**
     * Prints CSV data to the console.
     */
    public void printAirlinesByCountry(List<Airline> airlines) {
        for (Airline airline : airlines) {
            System.out.println(airline);
        }
    }

    public void printDestinationsByAirlineName(List<Airport> airports) {
        for (Airport airport : airports) {
            System.out.println(airport);
        }
    }

    public void printDestinationsByAirlineCode(List<Airport> airports) {
        for (Airport airport : airports) {
            System.out.println(airport);
        }
    }

    public void printRoutes(List<Route> routes) {
        for (Route route : routes) {
            System.out.println(route);
        }
    }
}