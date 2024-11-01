import java.util.Scanner;

public class Main {
    public static final int ASCI_NUM = 128;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int[] count = new int[ASCI_NUM];
        
        for(int i=0;i<str1.length();i++){
            count[str1.charAt(i)]++;
        }
        for(int i=0;i<str2.length();i++){
            count[str2.charAt(i)]--;
        }
        for(int i=0;i<ASCI_NUM;i++){
            if(count[i]!=0){
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");

    }
}