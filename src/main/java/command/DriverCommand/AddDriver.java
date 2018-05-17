package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import model.Driver;

import javax.servlet.http.HttpServletRequest;

public class AddDriver implements ICommand{
    private static final String DRIVER_ID = "driverID";
    private static final String NAME="name";
    private static final String SURNAME="surname";
    private static final String PHONE_NUMBER="phoneNumber";
    private static final String SALARY="Salary";
    private static final String ROUTE_NUMBER="routeNumber";
    private static final String BUS_NUMBER="busNumber";

    @Override
    public void execute(HttpServletRequest request) {
        DriverDAOimpl driverDAO = new DriverDAOimpl();
        Driver driver = new Driver(Integer.parseInt(request.getParameter(DRIVER_ID)),
                (String) request.getParameter(NAME),
                (String) request.getParameter(SURNAME),
                (String) request.getParameter(PHONE_NUMBER),
                Integer.parseInt(request.getParameter(SALARY)),
                Integer.parseInt(request.getParameter(ROUTE_NUMBER)),
                (String) request.getParameter(BUS_NUMBER));
        driverDAO.addDriver(driver);

        log.info("New Driver(" + driver.getDriverID() + ") was added");
    }
}
