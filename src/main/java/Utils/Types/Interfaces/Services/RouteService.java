package Utils.Types.Interfaces.Services;

import Utils.Types.Records.Route;

import java.util.List;

public interface RouteService {
    void saveRoutes(List<Route> routes);

    List<Route> getAllRoutes();

    List<Route> findByAirlineId(int airlineId);
}
