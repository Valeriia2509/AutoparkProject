package command.RouteCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import dao.RouteDAO.RouteDAOimpl;

import javax.servlet.http.HttpServletRequest;

public class SetBus implements ICommand{
    private static final String VEHICLE_PLATE = "vehiclePlate";
    private static final String ROUTE_NUMBER = "routeNumber";

    @Override
    public void execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter(VEHICLE_PLATE);
        int routeNumber = Integer.parseInt(request.getParameter(ROUTE_NUMBER));
        busDAO.setRoute(routeNumber, vehiclePlate);

        RouteDAOimpl routeDAO = new RouteDAOimpl();
        routeDAO.setBus(vehiclePlate, routeNumber);

        log.info("Bus(" + vehiclePlate + ") added to Route(" + routeNumber);
    }
}
