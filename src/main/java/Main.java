import Utils.Downloader.DatFileDownloader;
import Utils.Parser.CSVParser;
import Utils.Printer.DataPrinter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Main class to demonstrate downloading, parsing and printing data from a .dat file containing CSV data.
 */
public class Main {

    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/jpatokal/openflights/master/data/airlines.dat";

        try {
            DatFileDownloader downloader = new DatFileDownloader();
            Path airlineData = downloader.downloadFile(url);

            CSVParser parser = new CSVParser();
            List<String[]> data = parser.parse(airlineData);

            DataPrinter printer = new DataPrinter();
            printer.print(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

