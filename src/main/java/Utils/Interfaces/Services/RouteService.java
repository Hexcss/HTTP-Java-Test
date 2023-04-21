package Utils.Interfaces.Services;

import Records.Route;

import java.util.List;

public interface RouteService {
    void saveRoutes(List<Route> routes);

    List<Route> getAllRoutes();
}
