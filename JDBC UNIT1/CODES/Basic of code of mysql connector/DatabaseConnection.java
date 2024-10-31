import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    public static void main(String args[]){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
            System.out.println("MySQL Connected!");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
