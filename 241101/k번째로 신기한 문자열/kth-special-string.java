import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String T = sc.next();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){            
            String str = sc.next();
            if(str.startsWith(T)){
                list.add(str);
            }
        }
        Collections.sort(list);
        int cnt=0;
        for(String str: list){
            cnt++;
            if(cnt==k){
                System.out.println(str);
                System.exit(0);
            }
        }
    }
}