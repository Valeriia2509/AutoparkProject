package dao.BusDAO;

import Model.Bus;
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
            ps.setInt(2,bus.getRoute().getNumber());
            ps.setInt(3,bus.getDriver().getDriverID());
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
    public Bus getBus(String vehiclePlate) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        String sql="SELECT * FROM Buses WHERE vehiclePlate=?";
        ResultSet rs=null;
        Bus bus=null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,vehiclePlate);
            rs=ps.executeQuery();
            while(rs.next()){
                bus = new Bus();
                bus.setVehiclePlate(vehiclePlate);
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
        return  folders;

    }

    @Override
    public List<Bus> getBuses() {
        List<Bus> folders = new ArrayList<>();
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
                bus.setName(rs.getString(2));
                folders.add(folder);
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
        return  folders;
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
    public void setRoute(String vehicleint routeNumber) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="UPDATE Buses SET routeNumber=? WHERE idbook=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(UPDATE_BOOK);
            ps.setString(1, book.getName());
            ptmt.setString(2, book.getAuthor());
            ptmt.setInt(3, book.getQuantity());
            ptmt.setInt(4, pk);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            log.warn("SQLException at book update()", e);
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    cp.closeConnection(connection);
            } catch (SQLException e) {
                log.warn("SQLException at book update()", e);
            } catch (Exception e) {
                log.warn("Exception at book update()", e);

            }
        }
    }

    @Override
    public void setDriver(int driverID) {
    }
}
