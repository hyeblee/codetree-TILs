import java.util.*;

public class Main {
    public static boolean isLeafYear(int Y){
        if(Y%4==0){
            if(Y%100==0&&Y%400!=0)
                return false;
            return true;
        }
       
        return false;
    }

    public static String season(int M){
        if(M>=3&&M<=5)
            return "Spring";
        else if(M>=6&&M<=8)
            return "Summer";
        else if(M>=9&&M<=11)
            return "Fall";
        else if(M==1||M==1||M==2)
            return "Winter";
        else
            return "-1";
    }

    public static int monthEnd(int M, int Y){
        if(M==4||M==6||M==9||M==11)
          return 30;
        else if(M==2){
            if(isLeafYear(Y)){
                return 29;
            }
            else
                return 28;
        }
        else
            return 31;   
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        String result = season(M);
        // System.out.println("season"+season(M));
        // System.out.println(monthEnd(M,Y));
        if(D>monthEnd(M,Y))
            result = "-1";
        System.out.println(result);
    }
}