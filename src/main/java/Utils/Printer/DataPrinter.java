package Utils.Printer;

import Types.Records.Airline;
import Types.Records.Airport;
import Types.Records.Route;

import java.util.List;

/**
 * Class responsible for data.
 */
public class DataPrinter {

    public void printAirlinesByCountry(List<Airline> airlines) {
        printList(airlines);
    }

    public void printDestinationsByAirlineName(List<Airport> airports) {
        printList(airports);
    }

    public void printDestinationsByAirlineCode(List<Airport> airports) {
        printList(airports);
    }

    public void printRoutes(List<Route> routes) {
        printList(routes);
    }

    private <T> void printList(List<T> items) {
        items.forEach(System.out::println);
    }
}
