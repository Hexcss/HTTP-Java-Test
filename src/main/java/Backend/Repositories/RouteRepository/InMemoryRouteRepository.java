package Backend.Repositories.RouteRepository;

import Utils.Types.Records.Route;
import Utils.Types.Interfaces.Repositories.RouteRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Route> findByAirlineId(int airlineId) {
        return routes.stream()
                .filter(route -> route.airlineId() == airlineId)
                .collect(Collectors.toList());
    }
}
