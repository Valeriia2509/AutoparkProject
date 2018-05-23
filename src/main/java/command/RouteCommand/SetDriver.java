package command.RouteCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import dao.RouteDAO.RouteDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class SetDriver implements ICommand {
    private static final String NUMBER= "number";
    private static final String DRIVER_ID = "driverID";

    @Override
    public String execute(HttpServletRequest request) {
        DriverDAOimpl driverDAO = new DriverDAOimpl();
        int number = Integer.parseInt(request.getParameter(NUMBER));
        int driverID = Integer.parseInt(request.getParameter(DRIVER_ID));
        driverDAO.setRoute(number, driverID);

        RouteDAOimpl routeDAO = new RouteDAOimpl();
        routeDAO.setDriver(driverID, number);

        log.info("Driver" + driverID + " is assigned to Route(" + number + ")");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
