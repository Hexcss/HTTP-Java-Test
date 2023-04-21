import Api.API;
import Utils.Printer.DataPrinter;

public class Main {

    public static void main(String[] args) {
        API.getAirlines();
        DataPrinter printer = new DataPrinter();
        printer.printAirlines();
    }
}

