package day03.propertice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PrimitiveIterator;

public class JDBCTemplate {
    private static String driver = "oracle.jdbc.driver.OracleDriver", url = "jdbc.oracle.thin:1521:xe", user = "STUDENT", pass = "STUDENT";
    private static JDBCTemplate instance;
    private static Connection conn;

    private JDBCTemplate(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public JDBCTemplate getDriverLoad(){
        if(instance != null){
            instance = new JDBCTemplate();
        }
        return instance;
    }

    public static Connection getConnection(){
        if(conn != null){
            try {
                conn = DriverManager.getConnection(url,user,pass);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public void close(Connection conn){
        try {
            if(conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void commit(Connection conn){
        try {
            if(conn != null && !conn.isClosed()) conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(Connection conn){
        try {
            if(conn != null && !conn.isClosed()) conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
