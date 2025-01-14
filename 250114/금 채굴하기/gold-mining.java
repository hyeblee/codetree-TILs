import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static int n, m;
	public static int[][] grid = new int[20][20];

	public static int sum(int y, int x, int k) {
		int sum = 0;
		
		for (int dy = 0; dy < n; dy++) {
			for (int dx = 0; dx < n; dx++) {
				if(Math.abs(dy-y)+Math.abs(dx-x)<=k)
					sum += grid[dy][dx];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int maxCnt = 0;
		for (int k = 0; k <= 2*(n-1); k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = sum(i,j,k);
					if(num*m>=k*k+(k+1)*(k+1)) {
//						System.out.println(k*k+(k+1)*(k+1)+":  "+num);
						maxCnt = Math.max(maxCnt,num);
					}
				}
			}
		}
		System.out.println(maxCnt);
	}
}