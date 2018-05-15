package connection;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

public class Connector {
    private static Logger log=Logger.getLogger(Connector.class);

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Properties prop=new Properties();
            prop.put("user","root");
            prop.put("password","AAAbtrGGG");
            prop.put("autoReconnect","true");
            prop.put("characterEncoding","UTF-8");
            prop.put("useUnicode","true");
            String url="jdbc:mysql://localhost:3306/folders_and_files?useSSL=false";
            connection=DriverManager.getConnection(url,prop);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            log.error(e);
        }

        return connection;
    }
}
