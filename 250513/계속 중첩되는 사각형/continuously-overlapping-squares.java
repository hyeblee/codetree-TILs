import java.util.Scanner;
// 빨간색은 1, 파란색은 2


public class Main {
    public static int MAX_SIZE = 100;
    public static int grid[][] = new int[MAX_SIZE*2+1][MAX_SIZE*2+1];
    public static int result = 0;

    // 파란색으로 칠하는 메서드
    public static void paintBlue(int x1, int y1, int x2, int y2){
        for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                grid[i][j] = 2;
            }
        }
    }
    // 빨간색으로 칠하는 메서드
    public static void paintRed(int x1, int y1, int x2, int y2){
        for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                grid[i][j] = 1;
            }
        }
    }

    // 파란색 영역 사이즈 구하는 메서드
    public static int getBlueArea(){
        for(int i=0;i<2*MAX_SIZE+1;i++){
            for(int j=0;j<2*MAX_SIZE+1;j++){
                if(grid[i][j]==2){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 빨간색부터 입력받음(짝수번째)
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt()+MAX_SIZE;
            int y1 = sc.nextInt()+MAX_SIZE;
            int x2 = sc.nextInt()+MAX_SIZE;
            int y2 = sc.nextInt()+MAX_SIZE;
            if(i%2==0){
                paintRed(x1,y1,x2,y2);
            } else{
                paintBlue(x1,y1,x2,y2);
                }
        }
        getBlueArea();
        System.out.println(result);
 
    }
}