package Utils.Printer;

import java.util.List;

/**
 * Class responsible for printing CSV data.
 */
public class DataPrinter {

    /**
     * Prints CSV data to the console.
     *
     * @param data A list of String arrays representing rows and fields in the CSV data.
     */
    public void print(List<String[]> data) {
        for (String[] row : data) {
            System.out.print("Row: ");
            for (String field : row) {
                System.out.print(field + " | ");
            }
            System.out.println();
        }
    }
}