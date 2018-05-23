package dao.DriverDAO;

import model.Driver;

import java.util.List;

public interface DriverDAO {
    void addDriver(Driver bus);
    List<Driver> getAllDrivers();
    void deleteDriver(int driverID);
    void setRoute(int routeNumber, int driverID);
    void setBus(String bus, int driverID);
}
