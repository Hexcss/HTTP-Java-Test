package Types.Interfaces.Repositories;

import Types.Records.Route;

import java.util.List;

public interface RouteRepository {
    void save(List<Route> routes);

    List<Route> findAll();
}
