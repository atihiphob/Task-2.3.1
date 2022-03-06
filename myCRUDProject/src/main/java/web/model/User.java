package web.model;



import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue (strategy = IDENTITY)
   @Column (name = "id")
   private int id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;


   public User() {}

   public User(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @Override
   public String toString() {
      return "User {" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' + '}';
   }
}
