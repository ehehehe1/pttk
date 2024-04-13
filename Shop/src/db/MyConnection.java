package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyConnection {
    private static final String SERVER_NAME = "MSI\\SQLEXPRESS";
    private static final int PORT = 1433;
    private static final String DATABASE_NAME = "QLCH2";
    private static final String USERNAME = "sa"; 
    private static final String PASSWORD = "12345";  

    private static Connection con=null;

    public static Connection getConnection() {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net",
                        SERVER_NAME, PORT, DATABASE_NAME);
                con = DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (Exception ex) {
                  System.out.println(ex.getMessage()); 
            }
        return con;
    }
}
