package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add (User user);
   User get (int id);
   void remove(int id);
   User update(User user);
   List<User> listUsers();
}
