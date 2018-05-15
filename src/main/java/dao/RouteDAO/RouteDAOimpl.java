package dao.RouteDAO;

import Model.Route;
import dao.AbstractDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOimpl extends AbstractDAO implements RouteDAO {

    private static Logger log= Logger.getLogger(RouteDAOimpl.class);

    @Override
    public void addRoute(Route route) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="INSERT INTO Routes(number, startRoute, endRoute, distance, bus, driverID) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,route.getNumber());
            ps.setString(2,route.getStart());
            ps.setString(3,route.getEnd());
            ps.setInt(4,route.getDistance());
            ps.setString(5,route.getBus());
            ps.setInt(6,route.getDriverID());
            ps.executeUpdate();
            connection.commit();
            log.info("Route added");
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
    public List<Route> getRoutes() {
        List<Route> routes = new ArrayList<>();
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        String sql="SELECT * FROM Routes";
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Route route = new Route();
                route.setNumber(rs.getInt(1));
                route.setStart(rs.getString(2));
                route.setEnd(rs.getString(3));
                route.setDistance(rs.getInt(4));
                route.setBus(rs.getString(5));
                route.setDriverID(rs.getInt(6));
                routes.add(route);
            }
            log.info("Got array of Routes");
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                log.error(e);
            }
            connectionPool.returnConnectionToPool(connection);
        }
        return  routes;
    }

    @Override
    public void deleteRoute(int number) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        String sql="DELETE FROM Routes WHERE number=?";
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
    public void setBus(String bus) {

    }

    @Override
    public void setDriver(int driverID) {

    }
}
