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

   public EntityManager getEntityManager() {
      return entityManager;
   }

   @Override
   public void add(User user) {
      getEntityManager().persist(user);
   }

   @Override
   public User get(int id) {
      return getEntityManager().find(User.class, id);
   }

   @Override
   public void remove(int id) {
      User userToDelete = getEntityManager().find(User.class, id);
      getEntityManager().remove(userToDelete);
//      getEntityManager().createQuery("delete from users where id = :id").setParameter("id", id).executeUpdate();
   }

   @Override
   public User update(User user) {
      return getEntityManager().merge(user);
   }

   @Override
   public List<User> listUsers() {
      return getEntityManager().createQuery("from User").getResultList();

   }
}
