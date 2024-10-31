import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/readCookie")
public class Read_cookie extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the cookies from the request
        Cookie[] cookies = request.getCookies();
        String username = null;

        // Check if the cookie exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue(); // Get the cookie value
                    break;
                }
            }
        }

        // Respond to the client
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (username != null) {
            out.println("<h2>Username from Cookie: " + username + "</h2>");
        } else {
            out.println("<h2>No Cookie Found</h2>");
        }
        out.println("</body></html>");
    }
}
