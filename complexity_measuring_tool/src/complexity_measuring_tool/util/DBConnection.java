package complexity_measuring_tool.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * 
 * @Autour Peiris.M.R.P - IT16173064
 * Singleton DBConnection
 */
public class DBConnection {
	
	private static DBConnection dBConnection;
    private Connection conn;
    
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/measure", "root", "mysql");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return conn;
    }

}
