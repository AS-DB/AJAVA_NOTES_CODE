import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/register")
public class HiddenForm extends HttpServlet {
	static final long serialVersionUID = 1;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType"); // Get the hidden field value

        // Respond to the user
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h2>Registration Successful!</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Hidden data in form: " + userType + "</p>");
        out.println("</body></html>");
    }
}

//localhost:8080/Servlets_ajava4/HTML_Hidden_form.html
