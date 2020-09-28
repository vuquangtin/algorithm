package algorithm.design.TSP;

import java.util.ArrayList;

public class TableResult {
	private ArrayList<Integer> city; // các thành phố
	private double fx; // Trị thích nghi
	private double pi; // Xác suất chọn pi
	private double qi; // Vị trí xác suất

	public ArrayList<Integer> getCity() {
		return city;
	}

	public void setCity(ArrayList<Integer> city) {
		this.city = city;
	}

	public double getFx() {
		return fx;
	}

	public void setFx(double fx) {
		this.fx = fx;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

	public double getQi() {
		return qi;
	}

	public void setQi(double qi) {
		this.qi = qi;
	}

}
