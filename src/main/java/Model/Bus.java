package Model;

public class Bus {
    private String vehiclePlate;
    private Route route;
    Driver driver;

    public Bus() {
    }

    public Bus(String vehiclePlate) {
        super();
        this.vehiclePlate = vehiclePlate;
    }

    public Bus(String vehiclePlate, Route route, Driver driver) {
        super();
        this.vehiclePlate = vehiclePlate;
        this.route = route;
        this.driver = driver;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public Route getRoute() {
        return route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
