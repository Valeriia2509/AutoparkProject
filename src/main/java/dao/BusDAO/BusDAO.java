package dao.BusDAO;

import model.Bus;

import java.util.List;

public interface BusDAO {
    public void addBus(Bus bus);
    public List<Bus> getBuses();
    public void deleteBus(String vehiclePlate);
    public void setRoute(int routeNumber, String vehiclePlate);
    public void setDriver(int driverID, String vehiclePlate);
}
