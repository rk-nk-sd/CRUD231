package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class UserDaoArrayListImpl {
    private static int ID_COUNT;
    private List<User> userList;

    {
        userList = new ArrayList<>();

        userList.add(new User( ++ID_COUNT,"Иван", "Царевич", "car-tridevyatoe@carstvo.rus"));
        userList.add(new User( ++ID_COUNT,"Алёша", "Попович", "alesha-tridevyatoe@carstvo.rus"));
        userList.add(new User( ++ID_COUNT,"Добрыня", "Никитыч", "dobrynya-tridevyatoe@carstvo.rus"));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getCurrentUser(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void createNewUser(User user) { user.setId(++ID_COUNT); userList.add(user); }

    public void updateUser(int id, User updatedUser) {
        User userWillUpdated = getCurrentUser(id);
        userWillUpdated.setName(updatedUser.getName());
        userWillUpdated.setSurname(updatedUser.getSurname());
        userWillUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        userList.removeIf(u -> u.getId() == id);
    }

    @Override
    public String toString() {
        return "UserDaoArrayListImpl{" +
                "userList=" + userList +
                '}';
    }
}
