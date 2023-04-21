package Repositories;

import Records.Route;
import Utils.Interfaces.Repositories.RouteRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryRouteRepository implements RouteRepository {
    private List<Route> routes = new ArrayList<>();

    @Override
    public void save(List<Route> routesList) {
        routes = new ArrayList<>(routesList);
    }

    @Override
    public List<Route> findAll() {
        return Collections.unmodifiableList(routes);
    }
}
