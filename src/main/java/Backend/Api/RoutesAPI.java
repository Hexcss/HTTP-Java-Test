package Backend.Api;

import Backend.Utils.Downloader.DatFileDownloader;
import Backend.Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

/**
 * The RoutesAPI class provides a simple way to download and parse route data from an external API.
 */
public class RoutesAPI {
    private final String RoutesAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

    /**
     * Constructor for the RoutesAPI class.
     *
     * @param propertiesFile the name of the configuration file that contains the API endpoint
     *
     * The constructor reads the properties file, retrieves the API endpoint URL,
     * and initializes the RoutesAPIEndpoint member variable.
     */
    public RoutesAPI(String propertiesFile) {
        String RoutesAPIEndpointTemp;
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (input != null) {
                properties.load(input);
                RoutesAPIEndpointTemp = properties.getProperty("api.route.endpoint");
            } else {
                throw new IOException("Configuration file 'config.properties' not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            RoutesAPIEndpointTemp = null;
        }
        RoutesAPIEndpoint = RoutesAPIEndpointTemp;
    }

    /**
     * The fetchRoutes method retrieves route data.
     *
     * @return a List of String arrays containing the parsed route data
     * @throws IOException if there's an issue downloading or parsing the data
     *
     * The method downloads a file from the RoutesAPIEndpoint and parses the data using the CSVParser.
     */
    public List<String[]> fetchRoutes() throws IOException {
        Path routeData = downloader.downloadFile(RoutesAPIEndpoint);
        return parser.parse(routeData);
    }
}
