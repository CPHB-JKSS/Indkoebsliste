import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (servletContext.getAttribute("userMap") == null) {
            Map<String, String> userMap  = new HashMap<>();
            userMap.put("test", "test");
            servletContext.setAttribute("userMap", userMap);
        }

        if (!((Map<String, String>)servletContext.getAttribute("userMap")).containsKey(name)) {
            //todo go to login
            request.setAttribute("message", "Brugernavnet du har indtastet, findes ikke.");
            request.getRequestDispatcher("WEB-INF/Opret.jsp").forward(request,response);
        }

        if (((Map<String, String>)servletContext.getAttribute("userMap")).get(name).equals(password)) {
            //todo go to indkøbsliste
            response.getWriter().println("Password is correct!");
            request.getRequestDispatcher("WEB-INF/Indkoebsliste.jsp").forward(request,response);
        }

        //todo go to login
        request.setAttribute("message", "Password is incorrect!");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
