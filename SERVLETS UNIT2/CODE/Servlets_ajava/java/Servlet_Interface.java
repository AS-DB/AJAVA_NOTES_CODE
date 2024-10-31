import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/fullServlet")
public class Servlet_Interface extends HttpServlet {
  static final long serialVersionUID = 1L;
    private ServletConfig config;

    //Initialization of the servlet
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Servlet initialized.");
    }

    //servlet configuration
    public ServletConfig getServletConfig() {
        return config;
    }

    //Service
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        System.out.println("Handling request in service method.");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>Servlet Interface</p>");
        out.println("<p>Servlet Info: " + getServletInfo() + "</p>");
        out.println("</body></html>");
    }

    // Provides metadata about the servlet
    public String getServletInfo() {
        return "FullServlet Version 1.0";
    }

    // Destruction and cleanup of resources
    public void destroy() {
        System.out.println("Servlet destroyed.");
    }
}
