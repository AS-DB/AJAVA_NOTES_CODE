import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/login")
public class Redirect_1 extends HttpServlet {
	static final long serialVersionUID = 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            // Redirect to sample1
            response.sendRedirect("/Servlets_ajava2/sample1.html");
        } else {
            // Redirect to sample2
            response.sendRedirect("/Servlets_ajava2/Sample2.html");
        }
    }
}

//localhost:8080/Servlets_ajava2/Login.html