import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/servlet/First_program")  //using this in order not making any changes to web.xml file 
public class First_program extends HttpServlet {
     static final long serialVersionUID = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        
        // Setting the content type
        response.setContentType("text/html");
        
        // Get the writer object to send the response
        PrintWriter out = response.getWriter();
        out.println("<h1>Set your heart ablazed🔥!!!</h1>");
    }
}
