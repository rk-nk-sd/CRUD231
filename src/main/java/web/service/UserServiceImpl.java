package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDaoArrayListImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDaoArrayListImpl userDao = new UserDaoArrayListImpl();

    @Override
    public void createNewUser(User user) {
        userDao.createNewUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getCurrentUser(int id) {
        return userDao.getCurrentUser(id);
    }

    @Override
    public void update(User user, int id) {
        userDao.updateUser(id, user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
