package Api;

import DB.DataBase;
import Utils.Downloader.DatFileDownloader;
import Utils.Parser.CSVParser;
import Utils.Printer.DataPrinter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class API {
    public static void setAirlines() {
        String url = "https://raw.githubusercontent.com/jpatokal/openflights/master/data/airlines.dat";

        try {
            DatFileDownloader downloader = new DatFileDownloader();
            Path airlineData = downloader.downloadFile(url);

            CSVParser parser = new CSVParser();
            List<String[]> data = parser.parse(airlineData);

            new DataBase(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
