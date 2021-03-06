package thuattoan.sinh.xaunhiphan;

/**
 * Hay liet ke cac day nhi phan do dai n ma trong do cum chu so 01 result hien
 * dung 2 lan
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/algorithm">https://github.com/
 *      vuquangtin/algorithm</a>
 *
 */
public class XauNhiPhanCo01XuatHien2Lan {

	private int sluong;

	// ham kiem tra so lan result hien cua cum chu so 01, neu result hien 2 lan
	// thi tra ve true
	public boolean check(int[] arr) {
		int dem = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0 && arr[i + 1] == 1) {
				dem++;
			}
		}

		if (dem == 2) {
			return true;
		}

		return false;
	}

	public void giaiThuat(int n) {
		int[] arr = new int[n];
		int i;
		// khoi tao cau hinh ban dau
		for (i = 0; i < arr.length; i++) {
			arr[i] = 0;

		}

		do {

			if (check(arr)) {
				sluong++;
				for (i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
				System.out.printf("\t" + sluong);
				System.out.println();
			}

			// duyet tu cuoi mang
			i = n - 1;
			while (i >= 0 && arr[i] == 1) {
				i--;
			}
			if (i >= 0) {
				arr[i] = 1;
				for (int j = i + 1; j < n; j++) {
					arr[j] = 0;

				}
			}

			// neu chuoi so co 2 lan result hien 01 thi in no ra

		} while (i >= 0);

	}

	public static void main(String[] args) {
		XauNhiPhanCo01XuatHien2Lan baiTap3 = new XauNhiPhanCo01XuatHien2Lan();
		baiTap3.giaiThuat(10);

	}
}