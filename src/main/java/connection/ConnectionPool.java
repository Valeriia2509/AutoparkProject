package connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.Stack;

public class ConnectionPool {
    private static ConnectionPool instance;
    private Stack<Connection> connectionsAvailable = new Stack<>();
    private Stack<Connection> connectionsUsed =  new Stack<>();
    private static Logger log=Logger.getLogger(ConnectionPool.class);

    private ConnectionPool(){
        ResourceBundle resource=ResourceBundle.getBundle("database");
        int poolSize=Integer.parseInt(resource.getString("db.poolsize"));
        for (int count = 0; count < poolSize; count++) {
            connectionsAvailable.push(ConnectorDB.getConnection());
        }
            log.info("Created ConnectionPool");
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnectionFromPool () {
        Connection newConnection;

        if (connectionsAvailable.size() != 0) {
            newConnection = connectionsAvailable.pop();
            connectionsUsed.push(newConnection);
            log.info("connection got from pool");
        } else {
            newConnection = ConnectorDB.getConnection();
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
