package algorithm.design.TSP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TSP {

	// Lưu quãng đường đi tốt nhất
	private ArrayList<Integer> best_move_city;
	// Số các thể trong quần thể
	private int number_population;

	// Tra về quãng đường đi tốt nhất
	public ArrayList<Integer> getBest_move_city() {
		return best_move_city;
	}

	public TSP(ArrayList<Point> position_city, int soquanthe, int solanlap) {

		// n số thành phố
		number_population = soquanthe;
		
		int n = position_city.size();

		// Khởi tạo quần thể
		int[][] population = new int[number_population][n];
		createPopulation(population, n);

		// Bảng kết quả
		ArrayList<TableResult> table = new ArrayList<TableResult>();
		createTable(table, population, n);

		// Tính độ thích nghi cho bảng kết quả
		calculatorTable(table, position_city);

		// Lấy vị trí thích nghi tốt nhất trong bảng kết quả
		int vt = posBestTable(table);
		// Gán thành phố tốt nhất
		best_move_city = table.get(vt).getCity();
		// displayTable(table);
		// System.err.println("Vi tri "+vt);
		// System.err.println(best_move_city);
		double fx = table.get(vt).getFx();
		//System.err.println(fx);
//		 System.out.println("---------------P(t)--------------------");
		 displayTable(table);

		int k = 0;
		do {

			// Tái sinh từ table
			Reproduction re = new Reproduction(table, number_population);
			ArrayList<TableResult> taisinh = re.getNew_tableresults();
			// System.out.println("Tái sinh P'(t) từ P(t)");
			// calculatorTable(taisinh, position_city);
			 displayTable(taisinh);

			// Lai
			Crossover cr = new Crossover(taisinh, number_population);
			ArrayList<TableResult> lai = cr.getNew_tableresult();
			// System.out.println("Lai Q(t) từ P'(t)");
			// calculatorTable(lai, position_city);
			// _calculatorTable(lai, position_city, lai.size());
			 displayTable(lai);

			// Đột biến
			Mutation mu = new Mutation(lai, lai.size());
			ArrayList<TableResult> dotbien = mu.getNew_tableresults();
			// System.out.println("Đột biến R(t) từ Q(t)");
			// _calculatorTable(dotbien, position_city, dotbien.size());
			 displayTable(dotbien);

			// Chọn lọc P(t) từ P'(t) Q(t) R(t) và P(t)
			table = chonQT(table, taisinh, lai, dotbien);
			calculatorTable(table, position_city);
			displayTable(table);
			
			int vt1 = posBestTable(table);
			// System.out.println(dotbien.get(vt1).getFx());

			if ((double) table.get(vt1).getFx() > (double) fx) {
				best_move_city = table.get(vt1).getCity();
				fx = table.get(vt1).getFx();
//				System.out.println(vt1);
//				System.out.println(fx);
//				System.out.println(table.get(vt1).getCity());
			}
			

			k++;
		} while (k < solanlap);

		// System.err.println(fx);
		// displayTable(table);

	}

	private ArrayList<TableResult> chonQT(ArrayList<TableResult> table,
			ArrayList<TableResult> taisinh, ArrayList<TableResult> lai,
			ArrayList<TableResult> dotbien) {
		ArrayList<TableResult> all = table;
		table.clear();

		all.addAll(taisinh);
		all.addAll(lai);
		all.addAll(dotbien);

		// Lấy giao của table, taisinh,lai,dotbien
		giaoQL(all);
		//System.out.println(all.size());

		if (all.size() < number_population) {
			themCT(all);
		}

		if (all.size() > number_population) {
			xoaCT(all);
		}

		return all;
	}

	private void xoaCT(ArrayList<TableResult> all) {
		sortQT(all);
		displayTable(all);
		while (all.size() != number_population) {
			all.remove(0);

		}

	}

	private void sortQT(ArrayList<TableResult> all) {
		for (int i = 0; i < all.size(); i++) {
			for (int j = 0; j < all.size(); j++) {
				if ((double) all.get(i).getFx() > (double) all.get(j).getFx()) {
					TableResult temp = all.get(i);
					all.set(i, all.get(j));
					all.set(j, temp);
				}
			}
		}

	}

	private void themCT(ArrayList<TableResult> all) {
		// Khởi tạo quần thể
		int n = all.get(0).getCity().size();
		int[][] population = new int[number_population][n];
		createPopulation(population, n);

		// Bảng kết quả
		ArrayList<TableResult> table = new ArrayList<TableResult>();
		createTable(table, population, n);
		int i = 0;
		while (all.size() != number_population) {
			all.add(table.get(i));
			i++;
		}

	}

	private void giaoQL(ArrayList<TableResult> all) {
		for (int i = 0; i < all.size(); i++) {
			for (int j = i + 1; j < all.size(); j++) {
				if (all.get(i).getCity().equals(all.get(j).getCity())) {
					all.remove(j);
				}
			}
		}
	}


	// Vị trí tốt nhất
	private int posBestTable(ArrayList<TableResult> ta) {
		int vt = 0;
		double fx = 0;
		for (int i = 0; i < ta.size(); i++) {
			if ((double) ta.get(i).getFx() > (double) fx) {
				fx = ta.get(i).getFx();
				vt = i;
			}
		}
		return vt;
	}

	// Hiển thị bảng kết quả
	private void displayTable(ArrayList<TableResult> table) {
		for (int i = 0; i < table.size(); i++) {
			System.out.println(i + "->" + table.get(i).getCity() + " | "
					+ table.get(i).getFx() + "|" + table.get(i).getPi() + "|"
					+ table.get(i).getQi());
		}

	}

	// Hàm tính Fx và Pi, Qi cho bảng kết quả
	private void calculatorTable(ArrayList<TableResult> table,
			ArrayList<Point> position_city) {
		double total_fx = 0;
		for (int i = 0; i < number_population; i++) {
			// Lấy cách di chuyển thành phố
			ArrayList<Integer> city = table.get(i).getCity();
			// Tính hàm gx
			double fx = (1000000 - eval(city, position_city));
			total_fx += fx;
			// Add vào bảng kết quả
			table.get(i).setFx(fx);
		}

		double qi = 0;
		for (int i = 0; i < number_population; i++) {
			double pi = table.get(i).getFx() / total_fx;
			qi += pi;
			table.get(i).setPi(pi);
			table.get(i).setQi(qi);
		}

	}

	// Anh em với calculatorTable
//	private void _calculatorTable(ArrayList<TableResult> table,
//			ArrayList<Point> position_city, int n) {
//		double total_fx = 0;
//		for (int i = 0; i < n; i++) {
//			// Lấy cách di chuyển thành phố
//			ArrayList<Integer> city = table.get(i).getCity();
//			// Tính hàm gx
//			double fx = (1 / eval(city, position_city));
//			total_fx += fx;
//			// Add vào bảng kết quả
//			table.get(i).setFx(fx);
//		}
//
//		double qi = 0;
//		for (int i = 0; i < n; i++) {
//			double pi = table.get(i).getFx() / total_fx;
//			qi += pi;
//			table.get(i).setPi(pi);
//			table.get(i).setQi(qi);
//		}
//
//	}

	// Hàm tính độ thích nghi của một các thể
	private double eval(ArrayList<Integer> city, ArrayList<Point> position_city) {
		double gx = 0;
		for (int i = 0; i < city.size() - 1; i++) {
			int i1 = city.get(i);
			int i2 = city.get(i + 1);
			gx += distance(position_city.get(i1), position_city.get(i2));
		}
		gx += distance(position_city.get(city.get(0)), position_city.get(city.get(city.size()-1)));
		return gx;
	}

	// Hàm tính khoảng cách 2 điểm
	private double distance(Point p1, Point p2) {
		double dis = 0;
		double x = p1.getX() - p2.getX();
		double y = p1.getY() - p2.getY();
		dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return dis;
	}

	// Hàm đưa các thành phố vào bảng kết quả
	private void createTable(ArrayList<TableResult> table, int[][] population,
			int n) {
		for (int i = 0; i < number_population; i++) {
			TableResult tableResult = new TableResult();
			ArrayList<Integer> city = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				city.add(population[i][j]);
			}
			tableResult.setCity(city);
			table.add(tableResult);
		}

	}

	// Hàm khởi tạo quần thể
	private void createPopulation(int[][] population, int n) {
		List<Integer> city = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			city.add(i);
		}

		for (int j = 0; j < n; j++) {
			population[0][j] = city.get(j);
		}

		for (int i = 1; i < number_population; i++) {
			Collections.shuffle(city);
			for (int j = 0; j < n; j++) {
				population[i][j] = city.get(j);
			}
		}

	}
}
