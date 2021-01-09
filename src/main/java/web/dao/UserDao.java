package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getCurrentUser(int id);
    public void createNewUser(User user);
    public void updateUser(int id, User updatedUser);
    public void delete(int id);
}
