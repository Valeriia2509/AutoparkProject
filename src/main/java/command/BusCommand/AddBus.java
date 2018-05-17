package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import model.Bus;

import javax.servlet.http.HttpServletRequest;

public class AddBus implements ICommand {

    private static final String VEHICLE_PLATE = "vehiclePlate";
    private static final String ROUTE_NUMBER = "routeNumber";
    private static final String DRIVER_ID = "driverID";

    @Override
    public void execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        Bus bus = new Bus((String) request.getParameter(VEHICLE_PLATE),
                Integer.parseInt(request.getParameter(ROUTE_NUMBER)),
                Integer.parseInt(request.getParameter(DRIVER_ID)));
        busDAO.addBus(bus);

        log.info("New Bus(" + bus.getVehiclePlate() + ") was added");
    }
}
