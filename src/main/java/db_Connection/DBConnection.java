package db_Connection;

import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private static Connection connection;
    private static DBConnection dbConnection;
    public static Connection getConnection(){
        final String name="";
        final String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://loccalhost/name",name,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static DBConnection getDBConnection(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
            return dbConnection;
        }
        return dbConnection;
    }
}
