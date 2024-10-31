import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Read {
    public static void main(String args[]) {
        try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");

            // Create a PreparedStatement for the SELECT query
            String select_data = "SELECT * FROM info WHERE id > ?";
             PreparedStatement pstmt = conn.prepareStatement(select_data);

            // Set the parameter value
            pstmt.setInt(1, 1);  // Replace ? with 18

            // Execute the query and get the result set
            ResultSet rs = pstmt.executeQuery();

            //result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " +id+ ",Name:"+ name);
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
