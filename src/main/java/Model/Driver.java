package Model;

public class Driver {
    private int driverID;
    private String name;
    private String surname;
    private String phoneNumber;
    private int salary;
    private int routeNumber;
    private String busNumber;

    public Driver(int driverID, String name, String surname, String phoneNumber, int salary) {
        super();
        this.driverID=driverID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.salary=salary;
    }

    public Driver(int driverID, String name, String surname, String phoneNumber, int salary, int routeNumber, String busNumber) {
        super();
        this.driverID=driverID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.salary=salary;
        this.routeNumber = routeNumber;
        this.busNumber = busNumber;
    }

    public int getDriverID() {
        return driverID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRoute(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
