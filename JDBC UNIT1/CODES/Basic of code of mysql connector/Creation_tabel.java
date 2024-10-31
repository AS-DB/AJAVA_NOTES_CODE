import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Creation_tabel {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "1234";

        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // Create a Statement object to execute SQL commands
            Statement stmt = conn.createStatement();
            
            // Create the table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS info (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                    "name VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'info' created or already exists.");

            // Insert records
            String insertSQL1 = "INSERT INTO info (name) VALUES ('Alice')";
            String insertSQL2 = "INSERT INTO info (name) VALUES ('Bob')";
            String insertSQL3 = "INSERT INTO info (name) VALUES ('Charlie')";
            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);
            System.out.println("Records inserted.");

            // Retrieve and display the data
            String selectSQL = "SELECT * FROM info";
            ResultSet rs = stmt.executeQuery(selectSQL);
            
            System.out.println("Retrieved records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
            
            // Close the ResultSet, Statement, and Connection
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error.");
            e.printStackTrace();
        }
    }
}
