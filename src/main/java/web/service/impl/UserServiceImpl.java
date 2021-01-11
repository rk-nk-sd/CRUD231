package web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoArrayListImpl;
import web.dao.UserDaoHibernateImpl;
import web.dao.UserDaoImp;
import web.dao.UserDaoJDBCImpl;
import web.model.User;
import web.service.UserService;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {
    private UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    @Transactional
    @Override
    public void createNewUser(User user) {
        userDao.createNewUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getCurrentUser(int id) {
        return userDao.getCurrentUser(id);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
