package Api;

import DB.DataBase;
import Utils.Downloader.DatFileDownloader;
import Utils.Parser.CSVParser;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

public abstract class API {
    public static void getAirlines() {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new IOException("Configuration file 'config.properties' not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String url = properties.getProperty("api.airline.endpoint");

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
