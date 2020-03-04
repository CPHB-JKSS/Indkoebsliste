import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OpretServlet", urlPatterns = {"/OpretServlet"})
public class OpretServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (((Map<String,String>)servletContext.getAttribute("userMap")).containsKey(name)) {
            request.setAttribute("message", "Username is already in use!");
            request.getRequestDispatcher("WEB-INF/Opret.jsp").forward(request,response);
        }

        ((Map<String,String>)servletContext.getAttribute("userMap")).put(name, password);
        request.setAttribute("message", "New user created!");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
