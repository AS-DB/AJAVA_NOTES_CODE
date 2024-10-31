import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
    static final long serialVersionUID = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "root", "password");

            // Prepare SQL UPDATE query
            String query = "UPDATE users SET username=?, email=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, newUsername);
            stmt.setString(2, newEmail);
            stmt.setString(3, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<h3>User updated successfully!</h3>");
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
