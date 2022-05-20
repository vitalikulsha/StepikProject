package service;

import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    private final DBService dbService;

    public UserService(DBService dbService) {
        this.dbService = dbService;
    }

    public boolean isExists(String login, String password){
        Session session = dbService.getFactory().openSession();
        UserDao dao = new UserDao(session);
        boolean isExists = dao.isUserExists(login, password);
        session.close();
        return isExists;
    }

    public void addUser(String login, String password){
        Session session = dbService.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserDao dao = new UserDao(session);
        User user = new User(login, password);
        dao.addUser(user);
        transaction.commit();
        session.close();
    }

}
