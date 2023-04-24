package Utils.Types.Interfaces.Repositories;

import Utils.Types.Records.Route;

import java.util.List;

public interface RouteRepository {
    void save(List<Route> routes);
    List<Route> findByAirlineId(int airlineId);

    List<Route> findAll();
}
