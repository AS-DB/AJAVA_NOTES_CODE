import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/servlet/servlet2")
public class Servlet2 extends HttpServlet {
	static final long serialVersionUID = 1;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Getting attributes passed from Servlet1
        String name = (String) request.getAttribute("name");
        String age = (String) request.getAttribute("age");

        // Generating content that will be included by Servlet1
        PrintWriter out = response.getWriter();
        out.println("<h3>Included content from Servlet2</h3>");
        out.println("<p>Servlet2 received the following details:</p>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
    }
}
