import java.util.Scanner;

public class Main {
    public static int[][] grid;
    public static int[][] cumSum;

    public static int getSum(int y1, int x1, int y2, int x2) {
        return cumSum[y2][x2] + cumSum[y1-1][x1-1] - cumSum[y1-1][x2] - cumSum[y2][x1-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n+1][m+1];
        cumSum = new int[n+1][m+1];



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = sc.nextInt();
                cumSum[i][j] = grid[i][j] - cumSum[i-1][j-1] + cumSum[i][j-1] + cumSum[i-1][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for(int k=i;k<=n;k++) {
                    for(int l=j;l<=m;l++) {
                        for(int a=1;a<=n;a++) {
                            for(int b=1;b<=m;b++) {
                                for(int c=a;c<=n;c++) {
                                    for(int d=b;d<=m;d++) {
                                        if (a <= k && b <= l) // 겹치면 cotinue;
                                            continue;
                                        int sum = getSum(i,j,k,l);
                                        sum += getSum(a,b,c,d);
                                        // if (sum > max)
                                        //     System.out.printf("%d: %d %d %d %d, %d %d %d %d\n",sum,i,j,k,l,a,b,c,d);
                                        max = Math.max(max, sum);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // for(int i=1;i<=n;i++) {
        //     for(int j=1;j<=m;j++) {
        //         for(int k=i;k<=n;k++) {
        //             for(int l=j;l<=m;l++) {
        //                 for(int a=+1;i<=n;i++) {
        //                     for(int b=)
        //                 }
        //             }
        //         }
        //     }
        // }

        System.out.println(max);
    }
}