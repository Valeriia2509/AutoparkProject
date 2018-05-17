package command.DriverCommand;

import command.ICommand;
import dao.DriverDAO.DriverDAOimpl;
import model.Driver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetDrivers implements ICommand {

    @Override
    public void execute(HttpServletRequest request) {
        List<Driver> drivers = new ArrayList<>();
        DriverDAOimpl driverDAO = new DriverDAOimpl();

        drivers = driverDAO.getDrivers();
    }
}