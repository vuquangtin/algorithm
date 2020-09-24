package thuattoan.basic.stream.system.inout;

import java.io.*;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class ReadChars {
	/*-
	 * Sử dụng lớp InputStreamReader, BufferedReader 
	Lớp tốt nhất để đọc dữ liệu nhập từ Console là lớp BufferedReader. 
	Tuy nhiên chúng ta không thể xây dựng một lớp BufferedReader trực tiếp từ System.in. 
	Thay vào đó chúng ta phải chuyển nó thành một luồng ký tự. Để làm điều này chúng ta dùng InputStreamReader chuyển bytes thành ký tự.
	
	Để có được một đối tượng InputStreamReader gắn với System.in ta dùng constructor của InputStreamReader.
	
	InputStreamReader(InputStream inputStream)
	
	Tiếp theo dùng đối tượng InputStreamReader đã tạo ra để tạo ra một BufferedReader dùng constructor BufferedReader.
	
	BufferedReader(Reader inputReader)
	
	Ví dụ: Tạo một BufferedReader gắn với Keyboard
	
	BufferedReader br = new BufferedReader(new
	
	InputStreamReader(System.in));
	
	Sau khi thực hiện câu lệnh trên, br là một luồng ký tự gắn với Console thông qua System.in.
	
	Ví dụ: Dùng BufferedReader đọc từng ký tự từ Console. Việc
	đọc kết thúc khi gặp dấu chấm (dấu chấm để kết thúc chương
	trình).
	 */
	public static void main(String args[]) throws IOException {
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nhap chuoi ky tu,gioi han dau cham.");
		// read characters
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != '.');

	}

}