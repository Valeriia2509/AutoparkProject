package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import manager.PagesManager;
import model.Driver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetDrivers implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        List<Driver> drivers = new ArrayList<>();
        DriverDAOimpl driverDAO = new DriverDAOimpl();

        drivers = driverDAO.getAllDrivers();

        String page = PagesManager.getInstance().getProperty(
                PagesManager.TEST_PAGE);
        return page;
    }
}