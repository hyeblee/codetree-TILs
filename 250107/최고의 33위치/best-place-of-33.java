import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static final int SIZE = 3;
	public static int n;
	public static int[][] grid = new int[20][20];
	public static int maxCount = 0;
	
	public static int getCoinCount(int rowS, int rowE, int colS, int colE) {
		int cnt = 0;
		for(int i=rowS;i<=rowE;i++) {
			for(int j=colS; j<=colE; j++) {
				cnt+=grid[i][j];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<n-SIZE+1;i++) {
			for(int j=0;j<n-SIZE+1;j++) {
				maxCount = Integer.max(maxCount, getCoinCount(i,i+SIZE-1,j,j+SIZE-1));
			}
		}
		
		System.out.println(maxCount);
	}
}