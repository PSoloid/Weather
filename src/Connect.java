import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by otk_prog on 11/08/17.
 */

public class Connect {
    public void dbConnect(String db_connect_string,
                          String db_userid,
                          String db_password)
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
            System.out.println("connected");
            Statement statement = conn.createStatement();
            String queryString = "select * from MeteoTab";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
                System.out.print(rs.getString(3));
                System.out.print(rs.getString(4));
                System.out.print(rs.getString(5));
                System.out.print(rs.getString(6));
                System.out.println(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Connect connServer = new Connect();
        System.out.println("Starting");
        connServer.dbConnect("jdbc:sqlserver://10.0.3.50\\otk_sql; databaseName=meteo", "otk4", "6736");
        System.out.print("Ending");
    }

}
