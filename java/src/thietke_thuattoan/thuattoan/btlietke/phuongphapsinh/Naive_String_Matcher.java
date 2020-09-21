package thuattoan.btlietke.phuongphapsinh;
/**
 * Thuật toán khớp chuỗi Naive_String_Matcher
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Naive_String_Matcher {
    public static void main(String[] agrs) {
        String T = "000010001010001";
        String P = "0001";

        //So sánh khớp chuỗi
        int n = T.length();
        int m = P.length();
        boolean flag = true;
        for (int s = 0; s <= n - m; s++) {
            flag = true;
            for (int i = 0; i < m; i++) {
                if (P.charAt(i) == T.charAt(s + i))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("Posittion of s:" + s);
        }
    }
}
/** Kết quả
*run:
*Posittion of s:1
*Posittion of s:5
*Posittion of s:11
*/