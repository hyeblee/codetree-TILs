import java.util.*;


public class Main {
    
    public static boolean isPalindrome(String str){
        int length = str.length();

        for(int i=0;i<length/2;i++){
            if(str.charAt(i)!=str.charAt(length-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        if(isPalindrome(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}