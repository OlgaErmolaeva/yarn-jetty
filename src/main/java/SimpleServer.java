import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;


public class SimpleServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/*");
        context.addServlet(new ServletHolder(new HelloServlet("Container CREATED")), "/container/request");

        String webDir = SimpleServer.class.getProtectionDomain()
            .getCodeSource().getLocation().toExternalForm();
        WebAppContext webappContext = new WebAppContext(webDir, "/index.html");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {context, webappContext });

        server.setHandler(contexts);

        server.start();
        server.join();
    }
}
