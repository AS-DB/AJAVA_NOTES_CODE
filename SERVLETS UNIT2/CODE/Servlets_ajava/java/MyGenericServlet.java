import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/MyGenericServlet")  
public class MyGenericServlet extends GenericServlet {  
    private static final long serialVersionUID = 1L;

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to GenericServlet</h1>");  
        out.println("</body></html>");
    }
}
