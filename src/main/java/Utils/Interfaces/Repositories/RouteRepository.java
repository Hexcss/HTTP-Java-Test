package Utils.Interfaces.Repositories;

import Records.Route;

import java.util.List;

public interface RouteRepository {
    void save(List<Route> routes);

    List<Route> findAll();
}
