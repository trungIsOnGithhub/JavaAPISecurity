import java.io.FileInputStream;
import java.util.Properties;

public class DBConfig {
    public String url;
    public String user;
    public String driver;
    public String password;

    public DBConfig() {
        try (
            FileInputStream fistream = new FileInputStream("db.properties")
        ) {
            Properties props = new Properties();

            props.load(fistream);

            url = props.getProperty("url");
            user = props.getProperty("user");
            driver = props.getProperty("driver");
            password = props.getProperty("password");
        }
        catch (IOException e) {
            System.out.println("[Error] unable to read db props file!");
            e.printStackTrace();
        }
    }
}