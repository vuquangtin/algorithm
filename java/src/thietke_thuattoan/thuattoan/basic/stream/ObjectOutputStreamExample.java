package thuattoan.basic.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

public class ObjectOutputStreamExample {

	public static void main(String[] args) throws IOException {
		//File dir = new File("C:/Test");
		// Tao thu muc C:/Test.
		//dir.mkdirs();

		// Tao mot luong ghi vào file ...
		FileOutputStream fos = new FileOutputStream("testObjectStream.txt");

		// Tạo đối tượng ObjectOutputStream bao lấy 'fos'.
		// Những gì ghi vào luồng này sẽ được đẩy xuống 'fos'.
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Ghi một String vào luồng.
		oos.writeUTF("This is student, pupil profiles");

		// Chú ý: Các đối tượng ghi được vào luồng phải
		// là kiểu Serializable.

		// Ghi một đối tượng Date vào luồng.
		oos.writeObject(new Date());

		Student student1 = new Student("Thanh", "Phan");
		Student student2 = new Student("Ngan", "Tran");
		Pupil pupil1 = new Pupil("Nguyen Van Ba");

		oos.writeObject(student1);
		oos.writeObject(pupil1);
		oos.writeObject(student2);

		oos.close();
		System.out.println("Write successful");
	}

}