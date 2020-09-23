package thuattoan.basic.stream;
import java.io.Serializable;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */


public class Student implements Serializable {
 
   private static final long serialVersionUID = -5074534753977873204L;
 
   private String firstName;
 
   private String lastName;
 
   public Student(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
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
 
}