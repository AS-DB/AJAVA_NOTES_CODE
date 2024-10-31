import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/servlet/addUser") 
public class AddUserServlet extends HttpServlet {
    static final long serialVersionUID = 1;

    // JDBC database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sample"; 
    private static final String USER = "root"; 
    private static final String PASS = "1234"; 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Establishing the connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query to insert user data
            String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);

            // Executing the insert operation
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                response.getWriter().println("User added successfully!");
            } else {
                response.getWriter().println("Failed to add user.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
