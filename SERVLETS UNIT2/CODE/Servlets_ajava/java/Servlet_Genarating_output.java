import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/first")
public class Servlet_Genarating_output extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello from Simple Servlet!</h2>");
        out.println("</body></html>");
    }
}
