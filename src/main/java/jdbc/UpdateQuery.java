
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class UpdateQuery extends DBConnection {

    public static int updQuery(String query) {
        Connection connection = createConnection();
        Statement statment= null;

        try {
            statment = connection.createStatement();
        }
        catch (SQLException e) {
            System.out.println("ExecuteQuery.java [Error] SQL Exception");
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("ExecuteQuery.java [Error] Null Pointer Exception");
            e.printStackTrace();
        }

        try {
            return st.executeUpdate(query);

        }
        catch (SQLException e) {
            System.out.println("ExecuteQuery.java [Error] SQL Exception");
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("ExecuteQuery.java [Error] Null Pointer Exception");
            e.printStackTrace();
        }

        return 0;
    }
}
