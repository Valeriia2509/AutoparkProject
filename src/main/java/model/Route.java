package model;

public class Route {
    private int number;
    private String start;
    private String end;
    private int distance;
    private String bus;
    private int driverID;

    public Route() {
    }

    public Route(int number, String start, String end, int distance, String bus, int driverID) {
        super();
        this.number = number;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.bus=bus;
        this.driverID=driverID;
    }

    public int getNumber() {
        return number;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public String getBus() {
        return bus;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
