package Backend.Utils.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for parsing CSV data from a .dat file.
 */
public class CSVParser {

    /**
     * Parses CSV data from a file.
     *
     * @param file The path of the file containing CSV data.
     * @return A list of String arrays representing rows and fields in the CSV data.
     * @throws IOException if an I/O error occurs.
     */
    public List<String[]> parse(Path file) throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                data.add(fields);
            }
        }

        return data;
    }
}