package command.DriverCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import dao.DriverDAO.DriverDAOimpl;

import javax.servlet.http.HttpServletRequest;

public class SetBus implements ICommand {
    private static final String VEHICLE_PLATE = "vehiclePlate";
    private static final String DRIVER_ID = "driverID";

    @Override
    public void execute(HttpServletRequest request) {
        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter(VEHICLE_PLATE);
        int driverID = Integer.parseInt(request.getParameter(DRIVER_ID));
        busDAO.setRoute(driverID, vehiclePlate);

        DriverDAOimpl driverDAO = new DriverDAOimpl();
        driverDAO.setBus(vehiclePlate, driverID);

        log.info("Driver" + driverID + " is assigned to Bus(" + vehiclePlate + ")");
    }
}
