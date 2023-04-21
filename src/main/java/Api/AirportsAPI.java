package Api;

import Utils.Downloader.DatFileDownloader;
import Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

public class AirportsAPI {
    private final String AirportsAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

    public AirportsAPI(String propertiesFile) {
        String AirportsAPIEndpointTemp;
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input != null) {
                properties.load(input);
                AirportsAPIEndpointTemp = properties.getProperty("api.airport.endpoint");
            } else {
                throw new IOException("Configuration file 'config.properties' not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            AirportsAPIEndpointTemp = null;
        }
        AirportsAPIEndpoint = AirportsAPIEndpointTemp;
    }

    public List<String[]> fetchAirports() throws IOException {
        Path airportData = downloader.downloadFile(AirportsAPIEndpoint);
        return parser.parse(airportData);
    }
}
