package thuattoan.basic.stream.system.inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class StringTokenizerSample {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int line = 0;
        while((s=br.readLine())!=null){
            line++;
            int n = Integer.parseInt(br.readLine());
            boolean status[] = new boolean[s.length()];
            
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    status[i] = true;
                }
            }
            
            System.out.printf("Case %d:\n",line);

            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                int min = Math.min(a,b);
                int max = Math.max(a,b);
                
                boolean same = true;
                
                for(int j=min;j<max;j++){
                    if(status[j]!=status[j+1]){
                        same = false;
                        break;
                    }
                }
                
                if(same){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }     
    }
}

