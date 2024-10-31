import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
    static final long serialVersionUID = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "root", "password");

            // Prepare SQL DELETE query
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<h3>User deleted successfully!</h3>");
            } else {
                out.println("<h3>User not found!</h3>");
            }

            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
