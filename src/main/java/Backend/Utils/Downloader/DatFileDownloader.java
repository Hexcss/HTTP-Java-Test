package Backend.Utils.Downloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Class responsible for downloading a file from a URL.
 */
public class DatFileDownloader {

    /**
     * Downloads a file from the given URL and stores it as a temporary file.
     *
     * @param url The URL to download the file from.
     * @return The path of the downloaded temporary file.
     * @throws IOException if an I/O error occurs.
     */
    public Path downloadFile(String url) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Path tempFile = Files.createTempFile("response_data", ".dat");
            Files.copy(connection.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
            return tempFile;
        } else {
            throw new IOException("GET request failed. Response Code: " + responseCode);
        }
    }
}