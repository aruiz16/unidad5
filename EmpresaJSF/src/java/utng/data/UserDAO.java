package utng.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import utng.model.User;

public class UserDAO extends DAO<User> {

    public UserDAO() {
        super(new User());
    }

    public User getOneById(User user)
            throws HibernateException {
        return super.getOneById(user.getIdUser());
    }

    public User login(User user) {
        List<String> parameters = new ArrayList<String>();
        List<Object> values = new ArrayList<Object>();
        parameters.add("username");
        parameters.add("password");
        values.add(user.getUsername());
        values.add(user.getPassword());
        
        user = query("SELECT u FROM "
                + modelo.getClass().getName()
                + " u WHERE u.username =:username "
                + "AND u.password=:password",
                parameters, values);
        return user;
    }
}
