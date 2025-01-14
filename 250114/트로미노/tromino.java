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
		
		for(int i = 0; i < 6; i++) {
			boolean isPossible = true;
			int sum = 0;
			for(int dy = 0; dy<3;dy++) {
				for(int dx=0;dx<3;dx++) {
					if(shape[i][dy][dx]==0)
						continue;
					if(x+dx>=m||y+dy>=n) {
						isPossible = false;
					}
					else
						sum += grid[y+dy][x+dx];
				}
			}
			if(isPossible)
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