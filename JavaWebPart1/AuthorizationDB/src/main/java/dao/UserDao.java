package dao;

import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDao {
    private final Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public boolean isUserExists(String login, String password){
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
        return user != null;
    }

    public void addUser(User user){
        session.save(user);
    }
}
