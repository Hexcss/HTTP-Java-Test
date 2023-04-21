package Utils.Printer;

import DB.Airline;
import DB.DataBase;

import java.util.List;

/**
 * Class responsible for printing CSV data.
 */
public class DataPrinter {

    /**
     * Prints CSV data to the console.
     */
    public void printAirlines() {
        for (Airline airline : DataBase.airlines) {
            System.out.println(airline);
        }
    }
}