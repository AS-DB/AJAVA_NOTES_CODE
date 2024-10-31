import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(
    urlPatterns = {"/servlet/contextExample"},
    initParams = {
        @WebInitParam(name = "adminEmail", value = "admin@example.com"),
        @WebInitParam(name = "websiteName", value = "MyWebApp")
    }
)
public class ServletContextExample extends HttpServlet {
	static final long serialVersionUID = 1;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Setting attribute to ServletContext
        ServletContext context = config.getServletContext();
        context.setAttribute("appVersion", "1.0.0");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        // Example of getInitParameter and getInitParameterNames
        String adminEmail = config.getInitParameter("adminEmail");
        String websiteName = config.getInitParameter("websiteName");
        
        // Get all init parameter names
        Enumeration<String> initParams = config.getInitParameterNames();

        // Example of getServletContextName
        String contextName = context.getServletContextName();

        // Example of getAttribute and setAttribute
        String appVersion = (String) context.getAttribute("appVersion");

        // Removing attribute
        context.removeAttribute("appVersion");

        // Example of getContext - obtain another context if needed
        ServletContext anotherContext = context.getContext("/otherApp");

        // Generating the response
        out.println("<html><body>");
        out.println("<h2>ServletConfig and ServletContext Example</h2>");
        out.println("<p>Admin Email: " + adminEmail + "</p>");
        out.println("<p>Website Name: " + websiteName + "</p>");

        out.println("<h3>Init Parameters:</h3>");
        while (initParams.hasMoreElements()) {
            String paramName = initParams.nextElement();
            out.println("<p>" + paramName + " = " + config.getInitParameter(paramName) + "</p>");
        }

        out.println("<p>Servlet Context Name: " + contextName + "</p>");
        out.println("<p>Application Version (before removal): " + appVersion + "</p>");

        // Check if another context was retrieved
        if (anotherContext != null) {
            out.println("<p>Another context obtained successfully.</p>");
        } else {
            out.println("<p>Another context not available.</p>");
        }

        out.println("</body></html>");
    }
}
