package dao.BusDAO;

import model.Bus;
import dao.AbstractDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAOimpl extends AbstractDAO implements BusDAO {

    private static Logger log=Logger.getLogger(BusDAOimpl.class);

    @Override
    public void addBus(Bus bus) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="INSERT INTO Buses(vehiclePlate,routeNumber,driverID) VALUES(?,?,?)";
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,bus.getVehiclePlate());
            ps.setInt(2,bus.getRouteNumber());
            ps.setInt(3,bus.getDriverID());
            ps.executeUpdate();
            connection.commit();
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
    public List<Bus> getBuses() {
        List<Bus> buses = new ArrayList<>();
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        String sql="SELECT * FROM Buses";
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(sql);
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
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                log.error(e);
            }
            connectionPool.returnConnectionToPool(connection);
        }
        return  buses;
    }

    @Override
    public void deleteBus(String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="DELETE FROM Buses WHERE vehiclePlate=?";
        PreparedStatement pr=null;
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,vehiclePlate);
            pr.executeUpdate();
            connection.commit();
            log.info("Bus deleted");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                pr.close();
            } catch (SQLException e) {
                log.error(e);
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }

    @Override
    public void setRoute(int routeNumber, String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="UPDATE Buses SET routeNumber=? WHERE vehiclePlate=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, routeNumber);
            ps.setString(2, vehiclePlate);
            ps.executeUpdate();
            connection.commit();
            log.info("Route set to Bus");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                log.error(e);
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }

    @Override
    public void setDriver(int driverID, String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="UPDATE Buses SET driverID=? WHERE vehiclePlate=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, driverID);
            ps.setString(2, vehiclePlate);
            ps.executeUpdate();
            connection.commit();
            log.info("Driver set to Bus");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                log.error(e);
            }
            connectionPool.returnConnectionToPool(connection);
        }
    }
}
