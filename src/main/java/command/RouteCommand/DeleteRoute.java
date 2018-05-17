package command.RouteCommand;

import command.ICommand;
import dao.RouteDAO.RouteDAOimpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteRoute implements ICommand {
    private static final String NUMBER = "number";

    @Override
    public void execute(HttpServletRequest request) {

        RouteDAOimpl routeDAO = new RouteDAOimpl();
        int number = Integer.parseInt(request.getParameter(NUMBER));
        routeDAO.deleteRoute(number);

        log.info("Route(" + number + ") deleted");
    }
}
