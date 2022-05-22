package servlet;

import server.AccountServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AdminServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AdminServlet.class.getName());

    private final AccountServer accountServer;

    public AdminServlet(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        LOG.info("Users limit: " + accountServer.getUsersLimit());
        response.getWriter().println(accountServer.getUsersLimit());
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
