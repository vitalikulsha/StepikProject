package main;

import accounts.AccountService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService service = new AccountService();

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(new SignUpServlet(service)), "/signup");
        handler.addServlet(new ServletHolder(new SignInServlet(service)), "/signin");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
