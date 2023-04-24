package Backend.Api;

import Backend.Utils.Downloader.DatFileDownloader;
import Backend.Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

/**
 * The AirportsAPI class provides a simple way to download and parse airport data from an external API.
 */
public class AirportsAPI {
    private final String AirportsAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

    /**
     * Constructor for the AirportsAPI class.
     *
     * @param propertiesFile the name of the configuration file that contains the API endpoint
     *
     * The constructor reads the properties file, retrieves the API endpoint URL,
     * and initializes the AirportsAPIEndpoint member variable.
     */
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

    /**
     * The fetchAirports method retrieves airport data.
     *
     * @return a List of String arrays containing the parsed airport data
     * @throws IOException if there's an issue downloading or parsing the data
     *
     * The method downloads a file from the AirportsAPIEndpoint and parses the data using the CSVParser.
     */
    public List<String[]> fetchAirports() throws IOException {
        Path airportData = downloader.downloadFile(AirportsAPIEndpoint);
        return parser.parse(airportData);
    }
}
