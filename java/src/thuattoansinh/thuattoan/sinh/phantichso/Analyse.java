package thuattoan.sinh.phantichso;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Analyse {
    public static void main(String[] args) {
        int n = 5;
        int[] x = new int[n];
        int[] t = new int[n];
        x[0] = 1;
        t[0] = 1;
        back(x, t, 1, n);
    }

    static void back(int[] x,int[] t, int i, int n) {
        for(int j = x[i-1]; j <= (n - t[i - 1])/2; j++) {
            x[i] = j;
            t[i] = j + t[i-1];
            back(x, t, i + 1, n);
        }
        x[i] = n - t[i - 1];
        for(int k = 0; k < i; k++) {
            System.out.print(x[k] + " + ");
        }
        System.out.print(x[i]);
        System.out.println();
    }
}