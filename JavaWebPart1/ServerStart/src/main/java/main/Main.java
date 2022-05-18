package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.MirrorServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        MirrorServlet servlet = new MirrorServlet();

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(servlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
