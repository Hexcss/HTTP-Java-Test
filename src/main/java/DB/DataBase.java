package DB;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Airline> airlines = new ArrayList<>();
    private List<String[]> airlinesData;

    public DataBase(List<String[]> airlinesData) {
        this.airlinesData = airlinesData;
        populateAirlines();
    }

    private void populateAirlines() {
        airlinesData.forEach(fields -> {
            int id = Integer.valueOf(fields[0]);
            String name = fields[1];
            String country = fields[6];
            boolean active = Boolean.parseBoolean(fields[7]);
            addAirlines(id, name, country, active);
        });
    }

    public void addAirlines(int id, String name, String country, boolean active) {
        airlines.add(new Airline(id, name, country, active));
    }
}

