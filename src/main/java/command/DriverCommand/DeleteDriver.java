package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteDriver implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        DriverDAOimpl driverDAO = new DriverDAOimpl();
        int driverID = Integer.parseInt(request.getParameter("driverID"));
        driverDAO.deleteDriver(driverID);

        log.info("Driver(" + driverID + ") deleted");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
