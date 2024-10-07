import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String o = st.nextToken();
        int c = Integer.parseInt(st.nextToken());
        int result=0;
        if(o.equals("+")){
            result=a+c;
        }
        else if(o.equals("-")){
            result=a-c;
        }
        else if(o.equals("/")){
            result=a/c;
        }
        else if(o.equals("*")){
            result=a*c;   
        }
        else{
            System.out.println("False");
            return;
        }

        System.out.printf("%d %s %d = %d\n",a,o,c,result);
    }
}