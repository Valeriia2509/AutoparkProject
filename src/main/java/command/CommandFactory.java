package command;

import command.BusCommand.*;
import command.DriverCommand.AddDriver;
import command.DriverCommand.DeleteDriver;
import command.DriverCommand.GetDrivers;
import command.RouteCommand.AddRoute;
import command.RouteCommand.DeleteRoute;
import command.DriverCommand.SetBus;
import command.additional.TestCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

public class CommandFactory {
    private static CommandFactory instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();
    private CommandFactory() {
        commands.put("addbus", new AddBus());
        commands.put("deletebus", new DeleteBus());
        commands.put("getbuses", new GetBuses());
        commands.put("bussetdriver", new SetDriver());
        commands.put("bussetroute", new SetRoute());
        commands.put("adddriver", new AddDriver());
        commands.put("deletedriver", new DeleteDriver());
        commands.put("getdrivers", new GetDrivers());
        commands.put("driversetbus", new SetBus());
        commands.put("driversetroute", new command.DriverCommand.SetRoute());
        commands.put("addroute", new AddRoute());
        commands.put("deleteroute", new DeleteRoute());
        commands.put("routesetbus", new command.RouteCommand.SetBus());
        commands.put("routesetdriver", new command.RouteCommand.SetDriver());
        commands.put("test", new TestCommand());
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = null;
        Enumeration<String> parameterNames= request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            if (parameter.startsWith("command")) {
                String action = request.getParameter(parameter);
                command = commands.get(action);
            }
        }
        return command;
    }
}
