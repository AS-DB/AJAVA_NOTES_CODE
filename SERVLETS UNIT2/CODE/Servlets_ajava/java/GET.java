import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/data")
public class GET extends HttpServlet {
	static final long serialVersionUID = 1L;
    // Handles GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Setting the content type of response to text/html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving query parameters from the URL (e.g., ?name=John)
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        // Writing the response back to the client
        out.println("<html><body>");
        out.println("<h2>GET Request</h2>");
        if (name != null && age != null) {
            out.println("<p>Hello, " + name + "!</p>");
            out.println("<p>You are " + age + " years old.</p>");
        } else {
            out.println("<p>No query parameters provided.</p>");
        }
        out.println("</body></html>");
    }
}


// localhost:8080/Servlets_ajava/servlet/data?name=ADITYA&age=19
