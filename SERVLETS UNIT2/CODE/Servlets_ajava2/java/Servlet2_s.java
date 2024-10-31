import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/servlet/servlet2_s")
public class Servlet2_s extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Getting attributes passed from Servlet1
        String name = (String) request.getAttribute("name");
        String age = (String) request.getAttribute("age");

        // Generating response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Servlet Collaboration Example</h2>");
        out.println("<p>Name:" + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("</body></html>");
    }
}
