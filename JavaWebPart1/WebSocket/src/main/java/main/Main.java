package main;

import chat.servlet.ChatServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        contextHandler.addServlet(new ServletHolder(new ChatServlet()), "/chat");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, contextHandler});
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
