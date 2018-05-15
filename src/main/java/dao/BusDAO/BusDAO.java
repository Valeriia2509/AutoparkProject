package dao.BusDAO;

import Model.Bus;

import java.util.List;

public interface BusDAO {
    public void addBus(Bus bus);
    public List<Bus> getBuses();
    public Bus getBus(String vehiclePlate);
    public void deleteBus(String vehiclePlate);
    public void setRoute(int routeNumber);
    public void setDriver(int driverID);
}
