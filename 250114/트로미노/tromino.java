import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main{
	public static int[][][] shape = {
			{{1,0,0},
			{1,1,0},
			{0,0,0}},
			
			{{0,1,0},
			{1,1,0},
			{0,0,0}},			
			
			{{1,1,0},
			{0,1,0},
			{0,0,0}},
			
			{{1,1,0},
			{1,0,0},
			{0,0,0}},
			
			{{1,0,0},
			{1,0,0},
			{1,0,0}},
			
			{{1,1,1},
			{0,0,0},
			{0,0,0}},
	};
	
	public static int[][] grid = new int[200][200];
	
	public static int n,m;

	public static int sum(int y, int x) {
		int max = 0;
		
		for(int k=0;k<6;k++) {
			int sum = 0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if((y+i>=n||x+j>=m)&&shape[k][i][j]==1) {
						sum = 0;
						break;
					}
					sum += grid[y+i][x+j]*shape[k][i][j];
				}
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				max = Math.max(max, sum(i,j));
			}
		}
		System.out.println(max);
	}
}