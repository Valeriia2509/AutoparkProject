package dao;

import connection.ConnectionPool;

public class AbstractDAO {
    protected ConnectionPool connectionPool;

    public AbstractDAO() {
        super();
        connectionPool=ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
