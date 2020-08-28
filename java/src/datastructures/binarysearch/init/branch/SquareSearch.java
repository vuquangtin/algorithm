package branch;

public class SquareSearch {

	/**
	 * 
	 * 
	 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
	 * @version 1.0.0
	 * @see <a
	 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
	 *
	 */
	public double square(double n) {
		double l = 0.00, r = n;
		while (true) {
			double mid = l + ((r - l) / 2);
			if ((mid - 0.000001) * (mid - 0.000001) < n
					&& (mid + 0.000001) * (mid + 0.000001) < n) {
				l = mid + 0.00001;
			} else if ((mid - 0.000001) * (mid - 0.000001) > n
					&& (mid + 0.000001) * (mid + 0.000001) > n) {
				r = mid - 0.00001;
			} else {
				return mid;
			}
		}

	}

	public static void main(String[] args) {
		double square = new SquareSearch().square(2.00);
		System.out.println(square);

		System.out.println(square * square);
	}

}
