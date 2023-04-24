package Backend.APIs.Airlines;

import Backend.Utils.Downloader.DatFileDownloader;
import Backend.Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

/**
 * The AirlinesAPI class provides a simple way to download and parse airline data from an external API.
 */
public class AirlinesAPI {
    private final String AirlinesAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

    /**
     * Constructor for the AirlinesAPI class.
     *
     * @param propertiesFile the name of the configuration file that contains the API endpoint
     *
     * The constructor reads the properties file, retrieves the API endpoint URL,
     * and initializes the AirlinesAPIEndpoint member variable.
     */
    public AirlinesAPI(String propertiesFile) {
        String AirlinesAPIEndpointTemp;
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input != null) {
                properties.load(input);
                AirlinesAPIEndpointTemp = properties.getProperty("api.airline.endpoint");
            } else {
                throw new IOException("Configuration file 'config.properties' not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            AirlinesAPIEndpointTemp = null;
        }
        AirlinesAPIEndpoint = AirlinesAPIEndpointTemp;
    }

    /**
     * The fetchAirlines method retrieves airline data.
     *
     * @return a List of String arrays containing the parsed airline data
     * @throws IOException if there's an issue downloading or parsing the data
     *
     * The method downloads a file from the AirlinesAPIEndpoint and parses the data using the CSVParser.
     */
    public List<String[]> fetchAirlines() throws IOException {
        Path airlineData = downloader.downloadFile(AirlinesAPIEndpoint);
        return parser.parse(airlineData);
    }
}
