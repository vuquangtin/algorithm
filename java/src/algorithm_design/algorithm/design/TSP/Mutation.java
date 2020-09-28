package algorithm.design.TSP;

import java.util.ArrayList;
import java.util.Random;

// Metation: Là hàm đột biến của giải thuật
public class Mutation {

	ArrayList<TableResult> new_tableresults;

	public ArrayList<TableResult> getNew_tableresults() {
		return new_tableresults;
	}

	public Mutation(ArrayList<TableResult> tableresults,int number_population) {

		new_tableresults = tableresults;
		// Số thành phố
		int n = tableresults.get(0).getCity().size();

		// System.out.println("n= " + n);
		// Lưu lại điểm gây đột biến pm=0.01
		ArrayList<Integer> mut = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < number_population * n; i++) {
			if (r.nextDouble() < 0.01) {
				mut.add(i);
			}
		}

		// System.out.println(mut);
		if (mut.size() > 0) {
			for (int i = 0; i < mut.size(); i++) {
				// Lấy ra điểm lai trong quần thể
				int p = mut.get(i);
				// /System.out.println("Vi tri: "+p);
				// Nằm ở hàng
				int h = p / n;
				// Nằm ở vị trí
				int v = p % n;
				// Lấy một vị trí đột biến nữa
				int v1 = getMul(v, n);

				ArrayList<Integer> vt = tableresults.get(h).getCity();
				ArrayList<Integer> vt1 = new_tableresults.get(h).getCity();

				 System.out.println("Hang: " + h + " Gia tri: " + vt);
				 System.out.println("Vi tri v: " + v);
				 System.out.println("Vi tri v1: " + v1);

				int _vt = vt.get(v);
				int _vt1 = vt.get(v1);
				// System.out.println("Gia tri: " + _vt);
				// System.out.println("Gia tri: " + _vt1);

				// Thay đổi trong vt1
				vt1.set(v, _vt1);
				vt1.set(v1, _vt);
				// System.out.println(vt1);
				new_tableresults.get(h).setCity(vt1);

			}
		}

	}

	private int getMul(int v, int n) {
		Random r = new Random();
		ArrayList<Integer> test = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			int m = r.nextInt(n);
			if (m != v) {
				test.add(m);
			}
		}
		return test.get(10);
	}

}
