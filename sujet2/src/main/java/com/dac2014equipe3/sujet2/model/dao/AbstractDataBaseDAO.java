package com.dac2014equipe3.sujet2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract Classe allowing to connect the DAO objects based on JDBC
 *
 * @author Philippe.Genoud@imag.fr
 */
public abstract class AbstractDataBaseDAO {

    private static final String CONN_URL = "jdbc:mysql://localhost:3306/sujet2";
    private static final String DBUSER = "root";
    private static final String PASSWD = "1234";

    /**
     * Returns a connection
     * @return null if connection is not possible, or the connection
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONN_URL, DBUSER, PASSWD);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDataBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /**
     * Closing connection
     *
     * @param c the connection
     * @throws java.sql.SQLException
     */
    protected static void closeConnection(Connection c) throws SQLException {
        if (c != null) {
            c.close();
        }
    }
}
