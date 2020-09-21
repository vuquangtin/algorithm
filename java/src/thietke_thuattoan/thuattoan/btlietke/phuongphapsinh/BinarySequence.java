package thuattoan.btlietke.phuongphapsinh;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class BinarySequence {
	/*-
	 * <Xây dựng cấu hình đầu tiên>
	while True:
	<In ra cấu hình đang có>
	if <đây là cấu hình cuối cùng>:
	    break
	<sinh cấu hình tiếp theo>
	 */
	public static void main(String[] args) {
		int m = 5;
		int[] seq = new int[m] ;
		for (int i = 0; i < seq.length; i++) {
			seq[i]=0;
		}
		boolean mBreak=false;
		while (true) {
			mBreak=true;
			System.out.println();
			for (int i = 0; i < seq.length; i++) {
				System.out.print("" + seq[i] );
			}
			
			for (int i = m - 1; i >= 0; i--) {
				if (seq[i] == 0) {
					seq[i] = 1;
					if (i + 1 < m) {
						for (int j = i + 1; j < m; j++) {
							seq[j] = 0;
						}
					}
					mBreak=false;
					break;
				}else{
					//seq[i] = 1;
				}
				
				
				
			}
			
			if(mBreak)
				break;
		}

	}
}
