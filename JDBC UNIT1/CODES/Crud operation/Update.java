import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Update{
    public static void main(String args[]) {
            try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");

            //PreparedStatement and setting parameter
            String update_data = "UPDATE info SET name = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(update_data);
            pstmt.setString(1, "ADI");  
            pstmt.setInt(2, 1);              
            
            // Execute the query
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student's name was updated successfully!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }     
}}
