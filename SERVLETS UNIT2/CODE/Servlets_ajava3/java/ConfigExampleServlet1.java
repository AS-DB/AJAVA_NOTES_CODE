import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigExampleServlet1 extends HttpServlet {
	static final long serialVersionUID = 1;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();

        // Example 1: getInitParameter()
        String email = config.getInitParameter("email");
        String website = config.getInitParameter("website");

        // Example 2: getInitParameterNames()
        Enumeration<String> initParamNames = config.getInitParameterNames();

        // Example 3: getServletContext()
        ServletContext context = config.getServletContext();

        // Example 4: getServletName()
        String servletName = config.getServletName();

        // Generating the HTML response
        out.println("<html><body>");
        out.println("<h2>ServletConfig Methods Example</h2>");

        out.println("<h3>Init Parameters:</h3>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Website: " + website + "</p>");
        
        out.println("<h3>All Init Parameters:</h3>");
        while (initParamNames.hasMoreElements()) {
            String paramName = initParamNames.nextElement();
            out.println("<p>" + paramName + ": " + config.getInitParameter(paramName) + "</p>");
        }

        out.println("<h3>Servlet Context:</h3>");
        out.println("<p>Server Info: " + context.getServerInfo() + "</p>");

        out.println("<h3>Servlet Name:</h3>");
        out.println("<p>Servlet Name: " + servletName + "</p>");
        out.println("</body></html>");
    }
}
