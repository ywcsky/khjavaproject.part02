package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
    private static Properties prop;
    // 싱글톤 패턴
    private static Connection conn;

    private JDBCTemplate() {

    }

    // 싱글톤 패턴


    public static Connection getConnection() {
        try {
            FileReader fr = new FileReader("src/resources/dev.properties");
            prop = new Properties();
            prop.load(fr);
            String url = prop.getProperty("url"), user = prop.getProperty("user"),driver = prop.getProperty("driver"),password = prop.getProperty("pass");
            if (conn == null || conn.isClosed()) {
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url,user,password);
                    conn.setAutoCommit(false);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException | IOException e) {
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
