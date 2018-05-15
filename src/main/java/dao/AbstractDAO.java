package dao;

import Connection.ConnectionPool;

public class AbstractDAO {
    protected ConnectionPool connectionPool = null;

    public AbstractDAO() {
        super();
        connectionPool=new ConnectionPool();
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
