import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/post")
public class POST extends HttpServlet {
	static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("<html><body>");
        out.println("<h2>POST Request</h2>");
        if (name != null && age != null) {
            out.println("<p>Hello, " + name + "!</p>");
            out.println("<p>You are " + age + " years old.</p>");
        } else {
            out.println("<p>Please fill out the form completely.</p>");
        }
        out.println("</body></html>");
    }
}

// localhost:8080/Servlets_ajava/form.html
