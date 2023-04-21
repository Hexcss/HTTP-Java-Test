package Api;

import Utils.Downloader.DatFileDownloader;
import Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

public class RoutesAPI {
    private final String RoutesAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

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

    public List<String[]> fetchRoutes() throws IOException {
        Path routeData = downloader.downloadFile(RoutesAPIEndpoint);
        return parser.parse(routeData);
    }
}
