package dao.RouteDAO;

import model.Route;

import java.util.List;

public interface RouteDAO {

    public void addRoute(Route route);
    public List<Route> getRoutes();
    public void deleteRoute(int number);
    public void setBus(String bus, int number);
    public void setDriver(int driverID, int number);
}
