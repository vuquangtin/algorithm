package thuattoan.basic.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
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

public class DataInputStreamExample {

	public static void main(String[] args) throws IOException {

		// Luồng đọc dữ liệu từ file.
		FileInputStream fis = new FileInputStream("cities.txt");
		// Tạo đối tượng DataInputStream bao lấy 'fis'.
		DataInputStream dis = new DataInputStream(fis);

		//
		// Đọc dữ liệu.
		//
		int cityId1 = dis.readInt();
		System.out.println("Id: " + cityId1);
		String cityName1 = dis.readUTF();
		System.out.println("Name: " + cityName1);
		int cityPopulation1 = dis.readInt();
		System.out.println("Population: " + cityPopulation1);
		float cityTemperature1 = dis.readFloat();
		System.out.println("Temperature: " + cityTemperature1);

		//
		// Đọc dữ liệu.
		//
		int cityId2 = dis.readInt();
		System.out.println("Id: " + cityId2);
		String cityName2 = dis.readUTF();
		System.out.println("Name: " + cityName2);
		int cityPopulation2 = dis.readInt();
		System.out.println("Population: " + cityPopulation2);
		float cityTemperature2 = dis.readFloat();
		System.out.println("Temperature: " + cityTemperature2);

		dis.close();
	}
}