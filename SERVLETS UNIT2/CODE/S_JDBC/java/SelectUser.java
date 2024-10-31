import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/SelectUser")
public class SelectUser extends HttpServlet {
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

            // Prepare SQL SELECT query
            String query = "SELECT * FROM users WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, userId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                out.println("<h3>User Details:</h3>");
                out.println("ID: " + rs.getString("id") + "<br>");
                out.println("Username: " + rs.getString("username") + "<br>");
                out.println("Email: " + rs.getString("email") + "<br>");
            } else {
                out.println("<h3>User not found!</h3>");
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
