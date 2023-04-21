package Services;

import Records.Route;
import Utils.Interfaces.Repositories.RouteRepository;
import Utils.Interfaces.Services.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void saveRoutes(List<Route> routes) {
        routeRepository.save(routes);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
