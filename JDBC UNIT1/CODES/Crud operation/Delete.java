import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Delete{
    public static void main(String args[]) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
	        String delete_data = "DELETE FROM info WHERE id = ?";

            //PreparedStatement and Setting the parameter
            
            PreparedStatement pstmt = conn.prepareStatement(delete_data);
            pstmt.setInt(1,902);

            // Execute the query
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student was deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
}}

