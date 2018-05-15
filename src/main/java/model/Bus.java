package model;

public class Bus {
    private String vehiclePlate;
    private int routeNumber;
    private int driverID;

    public Bus() {
    }

    public Bus(String vehiclePlate, int routeNumber, int driverID) {
        this.vehiclePlate = vehiclePlate;
        this.routeNumber = routeNumber;
        this.driverID = driverID;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
