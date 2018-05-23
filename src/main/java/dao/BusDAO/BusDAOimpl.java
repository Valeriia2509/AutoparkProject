package dao.BusDAO;

import dao.AbstractDAO;
import model.Bus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAOimpl extends AbstractDAO implements BusDAO {
    private static final String SQL_ADD_BUS="INSERT INTO Buses(vehiclePlate,routeNumber,driverID) VALUES(?,?,?)";
    private static final String SQL_GET_ALL_BUSES="SELECT * FROM Buses";
    private static final String SQL_DELETE_BUS="DELETE FROM Buses WHERE vehiclePlate=?";
    private static final String SQL_SET_ROUTE="UPDATE Buses SET routeNumber=? WHERE vehiclePlate=?";
    private static final String SQL_SET_DRIVER="UPDATE Buses SET driverID=? WHERE vehiclePlate=?";
    private static Logger log=Logger.getLogger(BusDAOimpl.class);

    @Override
    public void addBus(Bus bus) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_ADD_BUS);
            ps.setString(1,bus.getVehiclePlate());
            ps.setInt(2,bus.getRouteNumber());
            ps.setInt(3,bus.getDriverID());
            ps.executeUpdate();
            log.info("Bus added");
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
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(SQL_GET_ALL_BUSES);
            rs=ps.executeQuery();
            while(rs.next()){
                Bus bus = new Bus();
                bus.setVehiclePlate(rs.getString(1));
                bus.setRouteNumber(rs.getInt(2));
                bus.setDriverID(rs.getInt(3));
                buses.add(bus);
            }
            log.info("Got array of Buses");
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
        return  buses;
    }

    @Override
    public void deleteBus(String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_DELETE_BUS);
            ps.setString(1,vehiclePlate);
            ps.executeUpdate();
            log.info("Bus deleted");
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
    public void setRoute(int routeNumber, String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_ROUTE);
            ps.setInt(1, routeNumber);
            ps.setString(2, vehiclePlate);
            ps.executeUpdate();
            log.info("Route set to Bus");
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
    public void setDriver(int driverID, String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_DRIVER);
            ps.setInt(1, driverID);
            ps.setString(2, vehiclePlate);
            ps.executeUpdate();
            log.info("Driver set to Bus");
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
