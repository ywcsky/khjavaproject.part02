package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
    private static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER = "STUDENT";
    private static String PASS = "STUDENT";

    // 싱글톤 패턴
    private static Connection conn;

    private JDBCTemplate() {

    }

    // 싱글톤 패턴


    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                try {
                    Class.forName(DRIVER_NAME);
                    conn = DriverManager.getConnection(URL, USER, PASS);
                    conn.setAutoCommit(false);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
