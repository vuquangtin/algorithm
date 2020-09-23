package thuattoan.basic.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class ObjectInputStreamExample {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		// Tạo một luồng đọc file..
		FileInputStream fis = new FileInputStream("testObjectStream.txt");

		// Tạo đối tượng ObjectInputStream bao lấy 'fis'.
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Đọc ra đối tượng String:
		String s = ois.readUTF();

		System.out.println(s);

		// Đọc ra đối tượng Date.
		Date date = (Date) ois.readObject();
		System.out.println("Date = " + date);

		Student student1 = (Student) ois.readObject();

		System.out.println("Student " + student1.getFirstName());

		Pupil pupil = (Pupil) ois.readObject();

		System.out.println("Pupil " + pupil.getFullName());

		Student student2 = (Student) ois.readObject();

		System.out.println("Student " + student2.getFirstName());

		ois.close();
	}
}