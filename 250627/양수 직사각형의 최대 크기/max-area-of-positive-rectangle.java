import java.util.Scanner;
public class Main {

    public static int[][] grid;

    public static int getSize(int a, int b, int c, int d){
        int result = 0;
        for(int i=a;i<=c;i++){
            for(int j=b;j<=d;j++){
                if(grid[i][j]<=0){
                    return 0;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        int max = 0;
        for(int a=0;a<n;a++){
            for(int b=0;b<m;b++){
                if(grid[a][b]<=0)
                    continue;
                for(int c=a;c<n;c++){
                    for(int d=b;d<m;d++){
                        if(grid[c][d]<=0){
                            continue;
                        }
                        max = Math.max(max, getSize(a,b,c,d));
                        // System.out.println(max);
                    }
                }
            }
        }

        System.out.println(max);
    }
}