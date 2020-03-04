import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (servletContext.getAttribute("userMap") == null) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("test", "test");
            userMap.put("admin", "admin");
            servletContext.setAttribute("userMap", userMap);
        }

        if (((Set<String>) servletContext.getAttribute("activeUserSet")) == null) {
            Set<String> activeUserSet = new HashSet<>();
            servletContext.setAttribute("activeUserSet", activeUserSet);
        }

        if (!(session.getAttribute("message") == null)) {
            request.getRequestDispatcher("WEB-INF/Indkoebsliste.jsp").forward(request,response);
        }

        if (!((Map<String, String>) servletContext.getAttribute("userMap")).containsKey(name)) {
            request.setAttribute("message", "Brugernavnet du har indtastet, findes ikke.");
            request.getRequestDispatcher("WEB-INF/Opret.jsp").forward(request, response);
        }

        if (((Map<String, String>) servletContext.getAttribute("userMap")).get(name).equals(password)) {
            response.getWriter().println("Password is correct!");

            if (name.equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
            }

            if (!((Set<String>) servletContext.getAttribute("activeUserSet")).contains(name)) {
                ((Set<String>) servletContext.getAttribute("activeUserSet")).add(name);
                session.setAttribute("message", name + ": Logget ind.");
                session.setAttribute("name", name);
                request.getRequestDispatcher("WEB-INF/Indkoebsliste.jsp").forward(request, response);
            }
        }

        request.setAttribute("message", "Password is incorrect!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
