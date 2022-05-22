package servlet;

import resources.TestResource;
import sax.ReadXMLFileSAX;
import server.ResourceServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ResourcesServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ResourcesServlet.class.getName());

    private ResourceServer resourceServer;

    public ResourcesServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String path = request.getParameter("path");
        LOG.info("path: " + path);
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        LOG.info("resource: " + resource.toString());
        resourceServer.setTestResource(resource);
        response.setStatus(HttpServletResponse.SC_OK);
        LOG.info("doPost stopped");
    }
}
