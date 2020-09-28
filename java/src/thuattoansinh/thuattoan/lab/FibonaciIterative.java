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
public class FibonaciIterative {
    public static void main(String[] args) {
        System.out.print(fibonaci(6));
    }

    static int fibonaci(int n) {
        int f0 = 0;
        int f1 = 1;
        if(n == 0) {
            return f0;
        }
        if(n == 1) {
            return f1;
        }
        int fn = 0;
        for(int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}