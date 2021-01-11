package web.service;

import web.model.User;

import java.util.List;

public interface UserServiceR {
    User addUser(User user);
    void delete(int id);
    User getById(int id);
    User editUser(User user);
    List<User> getAll();
}
