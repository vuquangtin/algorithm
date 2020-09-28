/**
 * 
 */
package algorithm.design.TSP;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author SONY
 * 
 */

// Reproduction : Hàm tái sinh (Sinh sản) trong giải thuật
/*
 * Tái sinh là chọn quần thể mới thỏa phân bố xác suất dựa trên độ thích nghi
 */
public class Reproduction {

	private ArrayList<TableResult> new_tableresults;

	public ArrayList<TableResult> getNew_tableresults() {
		return new_tableresults;
	}

	public Reproduction(ArrayList<TableResult> tableresults,
			int number_population) {

		// Tạo bảng kết quả mới lưu lại thông tin khi quay bánh xe Roulette
		new_tableresults = new ArrayList<TableResult>();

		// Lưu lại giá trị lần quay
		double[] rulet = new double[number_population];
		turingRulet(rulet);
		 for(int i=0;i<number_population;i++){
		 System.out.println(rulet[i]);
		 }

		// Kiểm tra vi tri xác suất
		for (int i = 0; i < rulet.length; i++) {
			new_tableresults
					.add(Test(rulet[i], tableresults, number_population));
		}


	}


	private TableResult Test(double d, ArrayList<TableResult> tableresults,
			int number_population) {
		TableResult result = tableresults.get(0);
		for (int i = 0; i < number_population - 1; i++) {
			double l1 = tableresults.get(i).getQi();
			double l2 = tableresults.get(i + 1).getQi();
			if (l1 < d && d <= l2) {
				result = tableresults.get(i + 1);
				// System.out.println(l1+" < d <= "+l2+"=>"+i+"  =  "+result.getCity());
			}
		}
		return result;
	}

	private void turingRulet(double[] rulet) {
		Random r = new Random();
		for (int i = 0; i < rulet.length; i++) {
			rulet[i] = r.nextDouble();
		}
	}

}
