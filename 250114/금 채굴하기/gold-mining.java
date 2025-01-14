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
		
		for (int dy = y - k; dy <= y + k; dy++) {
			for (int dx = x - k; dx <= x + k; dx++) {
				if(dy<0||dy>=n||dx<0||dx>=n)
					continue;
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
		for (int k = 0; k <= n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = sum(i,j,k);
					if(num*m-k*k-(k+1)*(k+1)>=0) {
						maxCnt = num;
					}
				}
			}
		}
		System.out.println(maxCnt);
	}
}