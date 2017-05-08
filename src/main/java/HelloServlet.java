import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
    private String title;
    public HelloServlet(String title)
    {
        this.title=title;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>"+title+"</h1>");
        response.getWriter().println("priority: " + request.getParameter("priority"));
        response.getWriter().println("memory: " + request.getParameter("memory"));
        response.getWriter().println("containers: " + request.getParameter("containers"));
    }
}
