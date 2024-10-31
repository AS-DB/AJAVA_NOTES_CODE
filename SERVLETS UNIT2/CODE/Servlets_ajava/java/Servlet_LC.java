import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/lifecycle")
public class Servlet_LC extends HttpServlet {
    static final long serialVersionUID = 1L;

     // It will be shown console server is started
    public void init() throws ServletException {
        System.out.println("Servlet is being initialized.");
    }

    //It just handling service method GET which can be seen in browser
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Processing GET request.");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet Lifecycle is initiated succesfully!!👍</h1>");
        out.println("</body></html>");
    }

    // It will be shown console after server is shutdown
    public void destroy() {
        System.out.println("Servlet is being destroyed.");
    }
}

//localhost:8080/Servlets_ajava/servlet/lifecycle