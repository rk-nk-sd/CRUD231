package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userRepository;

    @Autowired
    public UserServiceImpl(UserDaoImpl userRepository) {
        this.userRepository = userRepository;
    }

    public User addNewUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User getCurrentUser(int id) {
        return userRepository.findById(id);
    }

    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
