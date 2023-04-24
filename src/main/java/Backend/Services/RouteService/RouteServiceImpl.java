package Backend.Services.RouteService;

import Utils.Types.Records.Route;
import Utils.Types.Interfaces.Repositories.RouteRepository;
import Utils.Types.Interfaces.Services.RouteService;

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

    @Override
    public List<Route> findByAirlineId(int airlineId) {
        return routeRepository.findByAirlineId(airlineId);
    }
}
