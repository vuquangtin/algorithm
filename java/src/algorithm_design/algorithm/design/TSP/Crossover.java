/**
 * 
 */
package algorithm.design.TSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author SONY
 * 
 */
// Hàm Lai ghép các cá thể của quần thể
// Dùng phép lai OX để lai 2 cá thể
// Xác suất lai pc = 0.25

public class Crossover {
	private ArrayList<TableResult> new_tableresult;

	public Crossover(ArrayList<TableResult> tableresult, int number_population) {

		new_tableresult = tableresult;

		// Lấy các vị trí lai
		ArrayList<Integer> pos = new ArrayList<Integer>();
		genPos(pos, number_population);
		System.out
				.println("Vi tri ca the trong quan the duoc lai ghep: " + pos);
		for (int i = 0; i < pos.size() / 2; i++) {
			Hybrid(pos.get(i * 2), pos.get(i * 2 + 1));
		}

		// System.out.println(new_tableresult.size());
	}

	private void Hybrid(Integer integer, Integer integer2) {
		// Lấy 2 bố mẹ
		ArrayList<Integer> p1 = new_tableresult.get(integer).getCity();
		ArrayList<Integer> p2 = new_tableresult.get(integer2).getCity();
		// Hiện thị 2 bố mẹ
		// System.out.println("Bo: " + p1);
		// System.out.println("Me: " + p2);

		// Random 2 vị trí lai
		ArrayList<Integer> pos_hybrid = new ArrayList<Integer>();
		posHyb(pos_hybrid, p1.size());
		Collections.sort(pos_hybrid);
		// System.out.println("Diem lai: " + pos_hybrid);

		// Tạo ra 2 con ban đầu
		ArrayList<Integer> v1 = new ArrayList<Integer>();
		ArrayList<Integer> v2 = new ArrayList<Integer>();
		v1 = p1;
		v2 = p2;
		// System.out.println("Bo: " + v1);
		// System.out.println("Me: " + v2);

		// sắp xếp lại các khoảng của p1,p2 bước 1 vừ vị trí 2
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = pos_hybrid.get(1); i < p1.size(); i++) {
			l1.add(p1.get(i));
			l2.add(p2.get(i));
		}
		// System.out.println("L1: " + l1);
		// System.out.println("L2: " + l2);

		// Từ đầu đến vị trí cắt 1
		for (int i = 0; i < pos_hybrid.get(1); i++) {
			l1.add(p1.get(i));
			l2.add(p2.get(i));
		}
		// System.out.println("L1: " + l1);
		// System.out.println("L2: " + l2);

		// Remove
		for (int i = pos_hybrid.get(0); i < pos_hybrid.get(1); i++) {
			l1.remove((Object) p2.get(i));
			l2.remove((Object) p1.get(i));
		}

		// System.out.println("L1: " + l1);
		// System.out.println("L2: " + l2);
		// System.out.println("V1: " + v1);
		// System.out.println("V2: " + v2);

		// Lần lượt đẩy vào v1 và v2
		for (int i = pos_hybrid.get(1); i < v1.size(); i++) {
			// System.out.println(i + "-" + k);
			v1.set(i, l2.get(0));
			l2.remove(0);
			v2.set(i, l1.get(0));
			l1.remove(0);
		}

		// System.out.println(l1);
		// System.out.println(l2);

		for (int i = 0; i < pos_hybrid.get(0); i++) {
			v1.set(i, l2.get(i));
			v2.set(i, l1.get(i));
		}

		// System.out.println("v1: " + v1);
		// System.out.println("v2: " + v2);

		// Ghi đề trong bảng kết quả
		// new_tableresult.get(integer).setCity(v1);
		// new_tableresult.get(integer2).setCity(v2);

		// Thêm vào bảng kết quả
		TableResult a = new TableResult();
		a.setCity(v1);
		new_tableresult.add(a);
		TableResult b = new TableResult();
		b.setCity(v2);
		new_tableresult.add(b);

	}

	private void posHyb(ArrayList<Integer> pos_hybrid, int i) {

		ArrayList<Integer> rd = new ArrayList<Integer>();
		for (int j = 1; j < i - 1; j++) {
			rd.add(j);
		}
		Collections.shuffle(rd);
		pos_hybrid.add(rd.get(0));
		pos_hybrid.add(rd.get(1));
	}

	private void genPos(ArrayList<Integer> pos, int number_population) {
		Random r = new Random();
		while (pos.size() < 2) {
			pos.clear();
			for (int i = 0; i < number_population; i++) {
				if (r.nextDouble() < 0.25) {
					pos.add(i);
				}
			}
		}

		if (pos.size() % 2 != 0) {
			pos.remove(pos.size() - 1);
		}

	}

	public ArrayList<TableResult> getNew_tableresult() {
		return new_tableresult;
	}

}
