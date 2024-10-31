import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/servlet/servlet1_s")
public class Servlet1_s extends HttpServlet {
	
	static final long serialVersionUID = 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input from the request
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        // Forward request to Servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("servlet2");
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        dispatcher.forward(request, response); 
    }
}

//localhost:8080/Servlets_ajava2/RD1.html