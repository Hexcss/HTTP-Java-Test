package Backend.Api;

import Backend.Utils.Downloader.DatFileDownloader;
import Backend.Utils.Parser.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

public class AirlinesAPI {
    private final String AirlinesAPIEndpoint;
    private final DatFileDownloader downloader = new DatFileDownloader();
    private final CSVParser parser = new CSVParser();

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

    public List<String[]> fetchAirlines() throws IOException {
        Path airlineData = downloader.downloadFile(AirlinesAPIEndpoint);
        return parser.parse(airlineData);
    }
}
