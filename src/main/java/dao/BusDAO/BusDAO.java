package dao.BusDAO;

import model.Bus;

import java.util.List;

public interface BusDAO {
    void addBus(Bus bus);
    List<Bus> getAllBuses();
    void deleteBus(String vehiclePlate);
    void setRoute(int routeNumber, String vehiclePlate);
    void setDriver(int driverID, String vehiclePlate);
}
