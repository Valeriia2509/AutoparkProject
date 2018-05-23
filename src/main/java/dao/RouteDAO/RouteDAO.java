package dao.RouteDAO;

import model.Route;

import java.util.List;

public interface RouteDAO {

    void addRoute(Route route);
    List<Route> getAllRoutes();
    void deleteRoute(int number);
    void setBus(String bus, int number);
    void setDriver(int driverID, int number);
}
