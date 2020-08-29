package problems.p500plus.createclass;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CreateClass {
	public final static String DOMAIN = "https://www.techiedelight.com/";

	public static void main(String[] args) {
		String[] arrayURL = {
				"https://www.techiedelight.com/find-distinct-combinations-of-given-length/",
				"https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/",
				"https://www.techiedelight.com/find-sub-array-with-0-sum/" };
		System.out.println(createClass(arrayURL[arrayURL.length - 1]));
	}

	public static String createClass(String url) {
		url = url.replace(DOMAIN, "").replace("/", "");
		String name = "";
		boolean toUpperCase = false;
		for (int index = 0; index < url.length(); index++) {
			if (index == 0) {
				name = (url.charAt(index) + "").toUpperCase();
				continue;
			}
			if (url.charAt(index) == '-') {
				toUpperCase = true;
				continue;
			}
			if (toUpperCase) {
				name += (url.charAt(index) + "").toUpperCase() + "";
				toUpperCase = false;
			} else {
				name += url.charAt(index) + "";
			}

		}

		return name;
	}
}
