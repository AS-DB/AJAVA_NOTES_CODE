import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/servlet/login")
public class LoginServlet extends HttpServlet {
    static final long serialVersionUID = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            // Correct redirection to welcome.jsp
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            // Redirect back to login.html if authentication fails
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }
}
