import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        String name = request.getParameter("name");

        if (!((Map<String,String>)servletContext.getAttribute("userMap")).containsKey(name)) {

            request.setAttribute("message", "Username: '" + name + "' does not exist!");
            request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
        }

        ((Map<String,String>)servletContext.getAttribute("userMap")).remove(name);
        request.setAttribute("message", "Username: '" + name + "' was removed!");
        request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
