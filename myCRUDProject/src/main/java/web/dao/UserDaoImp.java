package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;


   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public User get(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void remove(int id) {
      User userToDelete = entityManager.find(User.class, id);
      entityManager.remove(userToDelete);
   }

   @Override
   public User update(User user) {
      return entityManager.merge(user);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("select u from User u", User.class).getResultList();

   }
}
