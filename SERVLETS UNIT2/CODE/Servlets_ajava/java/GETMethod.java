import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/servlet/search")
public class GETMethod extends HttpServlet {
   static final long serialVersionUID = 1L;

    // The doGet method handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the 'q' parameter from the URL query string
        String query = request.getParameter("q");

        // Set response content type to HTML
        response.setContentType("text/html");

        // Get PrintWriter to send HTML response
        PrintWriter out = response.getWriter();

        // Generate a basic HTML response
        out.println("<html><body>");
        out.println("<h1>Results for: " + query + "</h1>");
        out.println("</body></html>");
    }
}

//To check the code type the below URL in order to do that
//  http://localhost:8080/Servlets_ajava/servlet/search?q=ADITYA_DAS