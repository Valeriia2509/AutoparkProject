package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import dao.RouteDAO.RouteDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class SetRoute implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        DriverDAOimpl driverDAO = new DriverDAOimpl();
        int number = Integer.parseInt(request.getParameter("number"));
        int driverID = Integer.parseInt(request.getParameter("driverID"));
        driverDAO.setRoute(number, driverID);

        RouteDAOimpl routeDAO = new RouteDAOimpl();
        routeDAO.setDriver(driverID, number);

        log.info("Driver" + driverID + " is assigned to Route(" + number + ")");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
