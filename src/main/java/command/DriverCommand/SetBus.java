package command.DriverCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import dao.DriverDAO.DriverDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class SetBus implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter("vehiclePlate");
        int driverID = Integer.parseInt(request.getParameter("driverID"));
        busDAO.setRoute(driverID, vehiclePlate);

        DriverDAOimpl driverDAO = new DriverDAOimpl();
        driverDAO.setBus(vehiclePlate, driverID);

        log.info("Driver" + driverID + " is assigned to Bus(" + vehiclePlate + ")");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
