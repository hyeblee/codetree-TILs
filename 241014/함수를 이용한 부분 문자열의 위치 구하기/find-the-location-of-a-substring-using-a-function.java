import java.util.*;

public class Main {
    public static int func(String str, String part){
        for(int i=0;i<str.length();i++){
            boolean same = true;
            for(int j=0;j<part.length()&&i+j<str.length();j++){
                if(str.charAt(i+j)!=part.charAt(j)){
                    same = false;
                    break;
                }
            }
            if(same==true){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String part = sc.nextLine();

        System.out.println(func(str,part));
    }
}