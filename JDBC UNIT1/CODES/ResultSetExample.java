import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1234");
            
            String sql = "SELECT id, name FROM info";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Using ResultSetMetaData to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println("\nColumn Count: " + metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println("Column " + i + ": " + metaData.getColumnName(i));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

