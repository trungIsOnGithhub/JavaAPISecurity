package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
public class ExecuteQuery extends DBConnection {

    public static ResultSet exeQuery(String query) {
        Connection connection = createConnection();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultSet = statement.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println("[Error] Cannot create and execute: " + query);
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("[Error] Null Pointer Exception Execute Query: "+ query);
            e.printStackTrace();
        }

        return resultSet;
    }
}
