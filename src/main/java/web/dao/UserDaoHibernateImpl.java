package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository
public class UserDaoHibernateImpl implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext(unitName = "emf")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
//        return entityManager.createNativeQuery("SELECT * from users").getResultList();
        return entityManager.createQuery("from " + User.class.getName()).getResultList(); //session.createQuery("from User").list();
    }

    public void createNewUser(User user) {
        System.out.println("мы тут, добавляем user-а!!!");
        System.out.println("User.id = " + user.getId() + "User.name = " + user.getName() + "User.surname = " + user.getSurname() + "User.email = " + user.getEmail());
        entityManager.persist(user);
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public void updateUser(int id, User user) {
//        entityManager.merge(user);
        entityManager.merge(entityManager.find(User.class, id));
    }

    public User getCurrentUser(int id) {
        return entityManager.find(User.class, id);
    }
}
