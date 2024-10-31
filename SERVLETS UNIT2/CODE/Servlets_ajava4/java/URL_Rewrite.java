import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/profile")
public class URL_Rewrite extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user ID from the URL
        String userId = request.getParameter("id");

        // Create a response to display the user ID
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h2>User Profile</h2>");
        out.println("<p>Your User ID: " + userId + "</p>");
        out.println("</body></html>");
    }
}

//localhost:8080/Servlets_ajava4/url_rewrite.html