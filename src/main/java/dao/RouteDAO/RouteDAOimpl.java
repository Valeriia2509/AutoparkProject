package dao.RouteDAO;

import dao.AbstractDAO;
import model.Route;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOimpl extends AbstractDAO implements RouteDAO {
    private static final String SQL_ADD_ROUTE="INSERT INTO Routes(number, startRoute, endRoute, distance, bus, driverID) VALUES(?,?,?,?,?,?)";
    private static final String SQL_GET_ALL_ROUTES="SELECT * FROM Routes";
    private static final String SQL_DELETE_ROUTE="DELETE FROM Routes WHERE number=?";
    private static final String SQL_SET_BUS="UPDATE Routes SET bus=? WHERE number=?";
    private static final String SQL_SET_DRIVER="UPDATE Routes SET driverID=? WHERE number=?";
    private static Logger log= Logger.getLogger(RouteDAOimpl.class);

    @Override
    public void addRoute(Route route) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_ADD_ROUTE);
            ps.setInt(1,route.getNumber());
            ps.setString(2,route.getStart());
            ps.setString(3,route.getEnd());
            ps.setInt(4,route.getDistance());
            ps.setString(5,route.getBus());
            ps.setInt(6,route.getDriverID());
            ps.executeUpdate();
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
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(SQL_GET_ALL_ROUTES);
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
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
            connectionPool.returnConnectionToPool(connection);
        }
        return  routes;
    }

    @Override
    public void deleteRoute(int number) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(SQL_DELETE_ROUTE);
            ps.setInt(1,number);
            ps.executeUpdate();
            log.info("Route deleted");
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
    public void setBus(String bus, int number) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_BUS);
            ps.setString(1, bus);
            ps.setInt(2, number);
            ps.executeUpdate();
            log.info("Bus set to Route");
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
    public void setDriver(int driverID, int number) {
        Connection connection=getConnectionPool().getConnectionFromPool();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_SET_DRIVER);
            ps.setInt(1, driverID);
            ps.setInt(2, number);
            ps.executeUpdate();
            log.info("Driver set to Route");
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
