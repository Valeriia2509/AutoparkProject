package command.RouteCommand;

import command.ICommand;
import dao.RouteDAO.RouteDAOimpl;
import model.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GetRoutes implements ICommand {

    @Override
    public void execute(HttpServletRequest request) {
        List<Route> routes = new ArrayList<>();
        RouteDAOimpl routeDAO = new RouteDAOimpl();

        routes = routeDAO.getRoutes();
    }
}
