package thuattoan.sinh.hoanvi;
/*-
 * Enumerates all permutations on N elements.
 *  Two different approaches are included.
 *
 *  % java Permutations 3
 *  abc
 *  acb
 *  bac 
 *  bca
 *  cab
 *  cba
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Permutations {

    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }

    // print N! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
       int N = s.length();
       char[] a = new char[N];
       for (int i = 0; i < N; i++)
           a[i] = s.charAt(i);
       perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }  

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c;
        c = a[i]; a[i] = a[j]; a[j] = c;
    }



    public static void main(String[] args) {
       int N = 4;
       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String elements = alphabet.substring(0, N);
       perm1(elements);
       System.out.println();
       //perm2(elements);
    }

	/**
	 * Loop all from 0001 to 1111 to determine the current element is 0/1
	 * Dung cho bài toán chỉnh hợp/tổ hợp, lấy 1 hay 2,3... phần tử trong 1 tập 
	 */
	public static void loopAllBinaryToCheckGetOrNot() {
		int[] b = {1, 2, 3, 4};
		// mask: 0001 -> 1111
		for (int mask = 1; mask < 1<<b.length ; mask++) {
			System.out.println(Integer.toBinaryString(mask));
			for (int i = 0; i < b.length; i++) { // can extend to any integer
				if ((mask & (1<<i)) != 0) {
					System.out.println(mask + ": element " + i + " is  1");
					// process here!
				}
			}
			System.out.println("============");
		}
	}
    
}
