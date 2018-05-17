package command.BusCommand;

import command.ICommand;
import dao.BusDAO.BusDAOimpl;
import model.Bus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetBuses implements ICommand {

    @Override
    public void execute(HttpServletRequest request) {
        List<Bus> buses=new ArrayList<>();
        BusDAOimpl busDAO = new BusDAOimpl();

        buses=busDAO.getBuses();
    }
}
