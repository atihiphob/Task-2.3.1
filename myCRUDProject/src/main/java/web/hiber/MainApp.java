package web.hiber;

import web.config.MyDBConfig;
import web.model.User;
import web.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MyDBConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("Иван", "Иванов");
      User user2 = new User("Владимир", "Серпухов");
      User user3 = new User("Николай", "Безруков");
      User user4 = new User("Александр", "Масляков");
      User user5 = new User("Василий", "Малый");
      User user6 = new User("Петр", "Великий");
      User user7 = new User("Леонид", "Якубович");
      User user8 = new User("Александр", "Смертный");
      User user9 = new User("Кощей", "Бессмертный");
      User user10 = new User("Генерал", "Армейский");
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);
      userService.add(user6);
      userService.add(user7);
      userService.add(user8);
      userService.add(user9);
      userService.add(user10);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println();
      }
      context.close();
   }
}
