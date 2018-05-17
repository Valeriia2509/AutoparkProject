package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteBus implements ICommand {

    private static final String VEHICLE_PLATE = "vehiclePlate";

    @Override
    public void execute(HttpServletRequest request) {

        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter(VEHICLE_PLATE);
        busDAO.deleteBus(vehiclePlate);

        log.info("Bus(" + vehiclePlate + ") deleted");
    }
}
