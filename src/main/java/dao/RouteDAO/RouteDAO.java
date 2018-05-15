package dao.RouteDAO;

import Model.Route;

import java.util.List;

public interface RouteDAO {

    public void addRoute(Route route);
    public List<Route> getRoutes();
    public void deleteRoute(int number);
    public void setBus(String bus);
    public void setDriver(int driverID);
}
