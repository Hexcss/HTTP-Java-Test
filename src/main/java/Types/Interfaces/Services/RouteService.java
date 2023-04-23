package Types.Interfaces.Services;

import Types.Records.Route;

import java.util.List;

public interface RouteService {
    void saveRoutes(List<Route> routes);

    List<Route> getAllRoutes();
}
