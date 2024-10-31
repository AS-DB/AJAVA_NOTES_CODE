import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/createCookie")
public class Create_cookie extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a cookie
        Cookie cookie = new Cookie("username", "ADITYA_DAS");
        cookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
        response.addCookie(cookie); // Add cookie to response

        // Respond to the client
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Cookie has been set: " +cookie.getName() + " = "+ cookie.getValue() + "</h2>");
        out.println("</body></html>");
    }
}
