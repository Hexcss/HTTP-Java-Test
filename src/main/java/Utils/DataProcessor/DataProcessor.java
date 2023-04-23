package Utils.DataProcessor;

import Types.Records.Airline;
import Types.Records.Airport;
import Types.Records.Route;

import java.util.ArrayList;
import java.util.List;

public abstract class DataProcessor {
    public static List<Airline> processAirlinesData(List<String[]> airlinesData) {
        List<Airline> airlines = new ArrayList<>();
        airlinesData.forEach(fields -> {
            int id = Integer.parseInt(fields[0]);
            String name = fields[1].replaceAll("\"", "");
            String country = fields[6].replaceAll("\"", "");
            String activeField = fields[7].replaceAll("\"", ""); // Remove double quotes
            boolean active = validateActiveAirline(activeField.charAt(0));
            airlines.add(new Airline(id, name, country, active));
        });
        return airlines;
    }

    public static List<Airport> processAirportData(List<String[]> airportData) {
        List<Airport> airports = new ArrayList<>();
        airportData.forEach(fields -> {
            int id = Integer.parseInt(fields[0]);
            String name = fields[1].replaceAll("\"", "");
            String city = fields[2].replaceAll("\"", "");
            String country = fields[3].replaceAll("\"", "");
            airports.add(new Airport(id, name, city, country));
        });
        return airports;
    }

    public static List<Route> processRouteData(List<String[]> routeData) {
        List<Route> routes = new ArrayList<>();
        routeData.forEach(fields -> {
            int airlineId = Integer.parseInt(fields[1]);
            int sourceAirportId = Integer.parseInt(fields[3]);
            int destinationAirportId = Integer.parseInt(fields[5]);
            routes.add(new Route(airlineId, sourceAirportId, destinationAirportId));
        });
        return routes;
    }


    private static boolean validateActiveAirline(Character active) {
        return active.equals('Y');
    }
}
