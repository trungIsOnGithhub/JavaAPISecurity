
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class UpdateQuery extends DBConnection {

    public static int updQuery(String query) {
        Connection connection = createConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            return statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println("[Error] Cannot Update Query: " + query);
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("[Error] Null Pointer Exception while update Query: " + query);
            e.printStackTrace();
        }

        return 0;
    }
}
