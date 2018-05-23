package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import manager.PagesManager;
import model.Bus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetBuses implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        List<Bus> buses=new ArrayList<>();
        BusDAOimpl busDAO = new BusDAOimpl();

        buses=busDAO.getAllBuses();

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}
