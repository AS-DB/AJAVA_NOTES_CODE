import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/servlet/servlet1")
public class Servlet1 extends HttpServlet {
	static final long serialVersionUID = 1;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Getting parameters from the request
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        // Setting attributes to pass to Servlet2
        request.setAttribute("name", name);
        request.setAttribute("age", age);

        // Using RequestDispatcher to include content from Servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("servlet2");

        // Including Servlet2 content within Servlet1's output
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Output from Servlet1 (before include)</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        
        // Including Servlet2 response
        dispatcher.include(request, response);
        
        out.println("<h2>Output from Servlet1 (after include)</h2>");
        out.println("</body></html>");
    }
}


//localhost:8080/Servlets_ajava2/RD.html