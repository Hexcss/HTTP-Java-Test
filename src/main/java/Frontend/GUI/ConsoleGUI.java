package Frontend.GUI;

import Frontend.Animations.GoodbyeAnimation.GoodbyeAnimation;
import Frontend.Animations.WelcomeAnimation.WelcomeAnimation;
import Utils.Types.Interfaces.Services.AirlineService;
import Utils.Types.Interfaces.Services.AirportService;
import Utils.Types.Interfaces.Services.RouteService;
import Utils.Types.Records.Airline;
import Utils.Types.Records.Airport;
import Utils.Types.Records.Route;
import Frontend.Printer.DataPrinter;

import java.util.List;
import java.util.Scanner;

public class ConsoleGUI {
    private final AirlineService airlineService;
    private final AirportService airportService;
    private final RouteService routeService;
    private final DataPrinter dataPrinter = new DataPrinter();

    public ConsoleGUI(AirlineService airlineService, AirportService airportService, RouteService routeService) {
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.routeService = routeService;
    }

    private void printInColor(String text, String colorCode) {
        System.out.println(colorCode + text + "\033[0m");
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printSeparator() {
        System.out.println("\033[1;30m" + "--------------------------------------------------" + "\033[0m");
    }

    private int displayMenu(Scanner scanner) {
        clearConsole();

        printSeparator();
        System.out.println("Please select an option:");
        printInColor("1. Show airlines by country", "\033[1;33m");
        printInColor("2. Show destinations by airline name", "\033[1;33m");
        printInColor("3. Show destinations by airline code", "\033[1;33m");
        printInColor("4. Show routes", "\033[1;33m");
        printInColor("0. Exit", "\033[1;31m");
        printSeparator();

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left after reading an integer

        return option;
    }

    private void showAirlinesByCountry(Scanner scanner) {
        System.out.println("Please enter a country name:");
        String country = scanner.nextLine();
        List<Airline> airlines = airlineService.getAirlinesByCountry(country);
        printSeparator();
        dataPrinter.printAirlinesByCountry(airlines);
        printSeparator();
    }

    private void showDestinationsByAirlineName(Scanner scanner) {
        System.out.println("Please enter an airline name:");
        String airlineName = scanner.nextLine();
        List<Airport> airportsByName = airportService.getDestinationsByAirlineName(airlineName);
        printSeparator();
        dataPrinter.printDestinationsByAirlineName(airportsByName);
        printSeparator();
    }

    private void showDestinationsByAirlineCode(Scanner scanner) {
        System.out.println("Please enter an airline code:");
        int airlineCode = scanner.nextInt();
        List<Airport> airportsByCode = airportService.getDestinationsByAirlineCode(airlineCode);
        printSeparator();
        dataPrinter.printDestinationsByAirlineCode(airportsByCode);
        printSeparator();
    }

    private void showRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        printSeparator();
        dataPrinter.printRoutes(routes);
        printSeparator();
    }

    private void welcome() {
        WelcomeAnimation welcomeAnimation = new WelcomeAnimation();
        Thread welcomeThread = new Thread(welcomeAnimation);
        welcomeThread.start();
        try {
            welcomeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void exit() {
        GoodbyeAnimation goodbyeAnimation = new GoodbyeAnimation();
        Thread goodbyeThread = new Thread(goodbyeAnimation);
        goodbyeThread.start();
        try {
            goodbyeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        welcome();

        while (true) {
            int option = displayMenu(scanner);

            switch (option) {
                case 1:
                    showAirlinesByCountry(scanner);
                    break;
                case 2:
                    showDestinationsByAirlineName(scanner);
                    break;
                case 3:
                    showDestinationsByAirlineCode(scanner);
                    break;
                case 4:
                    showRoutes();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
}
