import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        str1 = new String(charArray1);
        str2 = new String(charArray2);

        if(str1.equals(str2)){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}