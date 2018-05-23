package connection;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

public class ConnectorDB {
    private static Logger log=Logger.getLogger(ConnectorDB.class);

    public static Connection getConnection(){
        ResourceBundle resource=ResourceBundle.getBundle("database");
        Connection connection=null;
        try {
            Class.forName("db.driver").newInstance();
            Properties prop=new Properties();
            prop.put("user","db.user");
            prop.put("password","db.password");
            prop.put("autoReconnect","db.autoReconnect");
            prop.put("characterEncoding","db.encoding");
            prop.put("useUnicode","db.useUnicode");
            String url=resource.getString("db.url");
            connection=DriverManager.getConnection(url,prop);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            log.error(e);
        }

        return connection;
    }
}
