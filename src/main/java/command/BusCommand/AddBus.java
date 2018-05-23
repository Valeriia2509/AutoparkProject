package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import manager.PagesManager;
import model.Bus;

import javax.servlet.http.HttpServletRequest;

public class AddBus implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        Bus bus = new Bus((String) request.getParameter("vehiclePlate"),
                Integer.parseInt(request.getParameter("routeNumber")),
                Integer.parseInt(request.getParameter("driverID")));
        busDAO.addBus(bus);
        log.info("New Bus(" + bus.getVehiclePlate() + ") was added");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
