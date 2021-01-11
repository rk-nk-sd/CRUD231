package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.id=:id")
    User findById(@Param("id") int id);
}
