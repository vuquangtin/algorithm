package thuattoan.basic.stream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class DataOutputStreamExample {
 
  public static void main(String[] args) throws IOException {
      int cityIdA = 1;
      String cityNameA = "Green Lake City";
      int cityPopulationA = 500000;
      float cityTempA = 15.50f;
 
      int cityIdB = 2;
      String cityNameB = "Salt Lake City";
      int cityPopulationB = 250000;
      float cityTempB = 10.45f;
 
      File dir = new File("C:/Test");
      dir.mkdirs();
 
      //
      // Tạo đối tượng FileOutputStream để ghi xuống file.
      //
      FileOutputStream fos = new FileOutputStream("C:/Test/cities.txt");
 
      // Tạo đối tượng DataOutputStream bao lấy 'fos'.
      // Dữ liệu ghi vào 'dos' sẽ được đẩy sang 'fos'.
      DataOutputStream dos = new DataOutputStream(fos);
 
      //
      // Ghi các dữ liệu vào luồng.
      //
      dos.writeInt(cityIdA);
      dos.writeUTF(cityNameA);
      dos.writeInt(cityPopulationA);
      dos.writeFloat(cityTempA);
 
      dos.writeInt(cityIdB);
      dos.writeUTF(cityNameB);
      dos.writeInt(cityPopulationB);
      dos.writeFloat(cityTempB);
 
      dos.flush();
      dos.close();
  }
 
}