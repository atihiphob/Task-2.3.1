package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public User get(int id) {
      return userDao.get(id);
   }

   @Override
   public void remove(int id) {
      userDao.remove(id);
   }

   @Override
   public User update(User user) {
      return userDao.update(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
