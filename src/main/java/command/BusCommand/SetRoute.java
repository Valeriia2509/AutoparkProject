package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import dao.RouteDAO.RouteDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class SetRoute implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter("vehiclePlate");
        int routeNumber = Integer.parseInt(request.getParameter("routeNumber"));
        busDAO.setRoute(routeNumber, vehiclePlate);

        RouteDAOimpl routeDAO = new RouteDAOimpl();
        routeDAO.setBus(vehiclePlate, routeNumber);

        log.info("Bus(" + vehiclePlate + ") added to Route(" + routeNumber);

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
