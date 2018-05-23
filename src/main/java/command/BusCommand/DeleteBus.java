package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import manager.PagesManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteBus implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {

        BusDAOimpl busDAO = new BusDAOimpl();
        String vehiclePlate = (String) request.getParameter("vehiclePlate");
        busDAO.deleteBus(vehiclePlate);

        log.info("Bus(" + vehiclePlate + ") deleted");

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
