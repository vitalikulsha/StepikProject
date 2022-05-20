package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.DBService;
import service.UserService;
import servlet.SignInServlet;
import servlet.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
        UserService userService = new UserService(dbService);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(new SignUpServlet(userService)), "/signup");
        handler.addServlet(new ServletHolder(new SignInServlet(userService)), "/signin");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
