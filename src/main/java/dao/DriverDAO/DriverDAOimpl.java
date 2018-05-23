package dao.DriverDAO;

import dao.AbstractDAO;
import model.Driver;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAOimpl extends AbstractDAO implements DriverDAO {
    private static final String SQL_ADD_DRIVER="INSERT INTO Drivers(driverID, name, surname, phoneNumber, salary, routeNumber, busNumber) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_GET_ALL_DRIVERS="SELECT * FROM Drivers";
    private static final String SQL_DELETE_DRIVER="DELETE FROM Drivers WHERE driverID=?";
    private static final String SQL_SET_DRIVER="UPDATE Drivers SET routeNumber=? WHERE driverID=?";
    private static final String SQL_SET_BUS="UPDATE Drivers SET bus=? WHERE driverID=?";
    private static Logger log=Logger.getLogger(DriverDAOimpl.class);

    @Override
    public void addDriver(Driver driver) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_ADD_DRIVER);
            ps.setInt(1,driver.getDriverID());
            ps.setString(2,driver.getName());
            ps.setString(3,driver.getSurname());
            ps.setString(4,driver.getPhoneNumber());
            ps.setInt(5,driver.getSalary());
            ps.setInt(6,driver.getRouteNumber());
            ps.setString(7,driver.getBusNumber());
            ps.executeUpdate();
            log.info("Driver added");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(SQL_GET_ALL_DRIVERS);
            rs=ps.executeQuery();
            while(rs.next()){
                Driver driver = new Driver();
                driver.setDriverID(rs.getInt(1));
                driver.setName(rs.getString(2));
                driver.setSurname(rs.getString(3));
                driver.setPhoneNumber(rs.getString(4));
                driver.setSalary(rs.getInt(5));
                driver.setRouteNumber(rs.getInt(6));
                driver.setBusNumber(rs.getString(7));
                drivers.add(driver);
            }
            log.info("Got array of Drivers");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
        return  drivers;
    }

    @Override
    public void deleteDriver(int driverID) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_DELETE_DRIVER);
            ps.setInt(1,driverID);
            ps.executeUpdate();
            log.info("Driver deleted");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }

    @Override
    public void setRoute(int routeNumber, int driverID){
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_DRIVER);
            ps.setInt(1, routeNumber);
            ps.setInt(2, driverID);
            ps.executeUpdate();
            log.info("Route set to Driver");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }

    @Override
    public void setBus(String bus, int driverID) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_BUS);
            ps.setString(1, bus);
            ps.setInt(2, driverID);
            ps.executeUpdate();
            log.info("Bus given to Driver");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }
}
