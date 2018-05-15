package connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Stack;

public class ConnectionPool {

    private int initialConnections = 5;
    private Stack<java.sql.Connection> connectionsAvailable = new Stack<>();
    private Stack<java.sql.Connection> connectionsUsed =  new Stack<>();
    private static Logger log=Logger.getLogger(ConnectionPool.class);

    public ConnectionPool(){
        super();
        for (int count = 0; count < initialConnections; count++) {
            connectionsAvailable.push(Connector.getConnection());
        }
            log.info("Created ConnectionPool");
    }

    public synchronized Connection getConnectionFromPool () {
        java.sql.Connection newConnection;

        if (connectionsAvailable.size() != 0) {
            newConnection = connectionsAvailable.pop();
            connectionsUsed.push(newConnection);
            log.info("connection got from pool");
        } else {
            newConnection = Connector.getConnection();
            connectionsUsed.push(newConnection);
            log.info("ConnectionPool is empty. New connection created.");
        }
        return newConnection;
    }

    public synchronized void returnConnectionToPool(Connection connection){
        if (connection!=null){
            connectionsAvailable.push(connection);
            connectionsUsed.pop();
            log.info("connection returned to pool");
        }
    }
}
