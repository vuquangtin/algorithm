package thuattoan.basic.stream;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Rot13 {
    
    /*-
     * <pre>
     *   a ==> n
     *   b ==> o
     *   c ==> p
     *   d ==> q
     *   e ==> r
     *   ...
     *   y ==> l
     *   z ==> m
     * </pre>
     */
    public static int rotate(int inChar) {
        int outChar;
         
        if (inChar >= (int) 'a' && inChar <= (int) 'z') {
            outChar = (((inChar - 'a') + 13) % 26) + 'a';
        } else if (inChar >= (int) 'A' && inChar <= (int) 'Z') {
            outChar = (((inChar - 'A') + 13) % 26) + 'A';
        } else {
            outChar = inChar;
        }
        return outChar;
    }
     
    // Test
    public static void main(String[] args)  {
        for(char ch='a'; ch<='z';ch++ ) {
            char m= (char)rotate(ch);
            System.out.println("ch="+ch+" ==> "+ m);    
        }      
         
    }
}