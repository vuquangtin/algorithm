package thuattoan.dequi;

/**
 * Đảo ngược một số nguyên
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class DaoSoDungDeQui {
	public void daoSo(int n) {
		if (n > 0) {
			System.out.print(n % 10);
			daoSo(n / 10);
		}
	}

	public static void main(String[] args) {
		DaoSoDungDeQui daoso = new DaoSoDungDeQui();
		daoso.daoSo(58542378);
	}

}
