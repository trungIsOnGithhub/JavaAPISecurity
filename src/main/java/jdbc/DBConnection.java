import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.DBConfig;

// https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html
public class DBConnection {

    public static Connection createConnection() {
        Connection connection = null;
        DBConfig dbConfig = new DBConfig();

        try {
            // try {
            //     Class.forName(dbConfig.driver);
            // }
            // catch (ClassNotFoundException ex) {
            //     System.out.println("[Error] unable to load driver class from classpath!");
            //     System.exit(1);
            // }

            // https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html
            connection = DriverManager.getConnection(
                dbConfig.url, dbConfig.user, dbConfig.password
            );

            System.out.println("[Info] DB Connection successful");

        } catch (SQLException e) {
            System.out.println("[Error] While Creating connection to database");
            e.printStackTrace();
        }
        return connection;
    }

}


