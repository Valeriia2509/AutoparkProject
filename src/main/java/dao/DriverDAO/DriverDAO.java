package dao.DriverDAO;

import model.Driver;

import java.util.List;

public interface DriverDAO {
    public void addDriver(Driver bus);
    public List<Driver> getDrivers();
    public void deleteDriver(int driverID);
    public void setRoute(int routeNumber, int driverID);
    public void setBus(String bus, int driverID);
}
