package command.RouteCommand;

import command.ICommand;
import dao.RouteDAO.RouteDAOimpl;
import model.Route;

import javax.servlet.http.HttpServletRequest;

public class AddRoute implements ICommand {
    private static final String NUMBER = "number";
    private static final String START_ROUTE="startRoute";
    private static final String END_ROUTE="endRoute";
    private static final String DISTANCE="distance";
    private static final String BUS="bus";
    private static final String DRIVER_ID="diverID";

    @Override
    public void execute(HttpServletRequest request) {
        RouteDAOimpl routeDAO = new RouteDAOimpl();
        Route route = new Route(Integer.parseInt(request.getParameter(NUMBER)),
                (String) request.getParameter(START_ROUTE),
                (String) request.getParameter(END_ROUTE),
                Integer.parseInt(request.getParameter(DISTANCE)),
                (String) request.getParameter(BUS),
                Integer.parseInt(request.getParameter(DRIVER_ID)));
        routeDAO.addRoute(route);

        log.info("New Route(" + route.getNumber() + ") was added");
    }
}
