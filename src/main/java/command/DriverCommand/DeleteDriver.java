package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteDriver implements ICommand {
    private static final String DRIVER_ID = "driverID";

    @Override
    public void execute(HttpServletRequest request) {

        DriverDAOimpl driverDAO = new DriverDAOimpl();
        int driverID = Integer.parseInt(request.getParameter(DRIVER_ID));
        driverDAO.deleteDriver(driverID);

        log.info("Driver(" + driverID + ") deleted");
    }
}
