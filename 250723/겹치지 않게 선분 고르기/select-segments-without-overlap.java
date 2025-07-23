import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] segments;
    public static boolean[] isSelected = new boolean[1001];
    public static int cnt = 0;
    public static int max = 0;

    public static void getMax(int depth) {
        if (depth==n){

            max = Math.max(cnt, max);
            return;
        }

        boolean canSelect = true;
        for(int i=segments[depth][0];i<=segments[depth][1];i++){
            if (isSelected[i]){
                canSelect = false;
                return;
            }
        }
        // System.out.println(canSelect+": "+ depth);
        if (canSelect) {
            cnt++;
            isSelected[depth] = true;
            for(int i=segments[depth][0];i<=segments[depth][1];i++){
                isSelected[i] = true;
            }       
            getMax(depth+1);
            
            cnt--;
            isSelected[depth] = false;
            for(int i=segments[depth][0];i<=segments[depth][1];i++){
                isSelected[i] = false;
            }
        } 
        
        getMax(depth+1);


    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        getMax(0);
        System.out.println(max);   
    }
}