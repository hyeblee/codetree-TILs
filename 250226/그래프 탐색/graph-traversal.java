import java.util.*;
import java.io.*;

public class Main {
	public static int N,M;
	public static int[][] matrix;
	public static boolean[] visit;
	public static int cnt = 0;
	
	public static void dfs(int start) {
		visit[start] = true;
		cnt++;
		for(int i=0;i<N;i++) {
			if(start!=i&&!visit[i]&&matrix[start][i]==1) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
	}
}