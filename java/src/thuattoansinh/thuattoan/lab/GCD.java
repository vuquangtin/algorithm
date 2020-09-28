package thuattoan.lab;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class GCD {
    public static void main(String []args) {
        System.out.println(gcd(6, 9));
    }

    static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        } else {
            return gcd(m, n % m);
        }
    }
}