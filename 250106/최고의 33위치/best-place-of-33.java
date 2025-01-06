import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static int n;
	public static int grid[][] = new int[20][20];
	public static int result = 0;
	
	public static int countCoin(int y, int x) {
		int count = 0;
		for(int i =0; i<3;i++) {
			for(int j=0;j<3;j++) {
				count +=grid[i+y][j+x];
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<n-2;j++) {
				result = Integer.max(result, countCoin(i,j));
			}
		}
		System.out.println(result);
		
	
	}
}