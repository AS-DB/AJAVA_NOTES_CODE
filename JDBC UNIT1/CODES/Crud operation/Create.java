import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
            String insert_data = "INSERT INTO info (id, name) VALUES (?, ?)";

            // Prepare statement
            PreparedStatement pstmt = conn.prepareStatement(insert_data);

            // Set the parameters
            pstmt.setInt(1, 902);
            pstmt.setString(2, "Aditya das");

            // Execute the update
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } 
        catch (Exception e) {
             System.out.println(e);
        }
}}
