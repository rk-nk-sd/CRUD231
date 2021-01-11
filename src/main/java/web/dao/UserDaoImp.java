package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
public class UserDaoImp implements UserDao {


   @Override
   public List<User> getAllUsers() {
      return null;
   }

   @Override
   public User getCurrentUser(int id) {
      return null;
   }

   @Override
   public void createNewUser(User user) {

   }

   @Override
   public void updateUser(int id, User updatedUser) {

   }

   @Override
   public void delete(int id) {

   }
}
