package chat.servlet;

import chat.service.ChatService;
import chat.websocket.ChatWebSocket;
import org.eclipse.jetty.websocket.servlet.*;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends WebSocketServlet {
    private static final int LOGOUT_TIME = 10 * 60 * 1000;
    private final ChatService service;

    public ChatServlet() {
        this.service = new ChatService();
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, resp) -> new ChatWebSocket(service));
    }
}
