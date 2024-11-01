import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int number = sc.nextInt();
            list.add(number);
            if(i%2==1){
                Collections.sort(list);
                System.out.print(list.get(list.size()/2)+" ");
            }
        }
    }
}