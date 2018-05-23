package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import manager.PagesManager;
import model.Driver;

import javax.servlet.http.HttpServletRequest;

public class AddDriver implements ICommand{

    @Override
    public String execute(HttpServletRequest request) {
        DriverDAOimpl driverDAO = new DriverDAOimpl();
        Driver driver = new Driver(Integer.parseInt(request.getParameter("driverID")),
                (String) request.getParameter("name"),
                (String) request.getParameter("surname"),
                (String) request.getParameter("phoneNumber"),
                Integer.parseInt(request.getParameter("Salary")),
                Integer.parseInt(request.getParameter("routeNumber")),
                (String) request.getParameter("busNumber"));
        driverDAO.addDriver(driver);

        log.info("New Driver(" + driver.getDriverID() + ") was added");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
