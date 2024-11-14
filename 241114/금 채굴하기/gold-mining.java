
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_SIZE = 20;
	
	public static int n,m;
	public static int[][] grid = new int[MAX_SIZE][MAX_SIZE];
	
	public static int getNumOfGold(int row, int col, int k) {
		int cnt=0;
		// 중심이 (row,col)이고 크기가 k인 마름모 범위 탐색법:
		// 전체 격자에서, 중심에서 k이내로 떨어진 범위만 탐색한다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// 범위 아니면 탐색 안함
				if(Math.abs(row-i)+Math.abs(col-j)<=k)
					cnt += grid[i][j];
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 격자 크기
		m = sc.nextInt(); // 금 비용
		
		// 마름모 중심은 격자 안의 모든 칸이ㅣ 될 수 있다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int maxGold = 0;
		// 격자의 모든 곳이 중심점이 될 수 있다!
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<=2*(n-1);k++) {
					int cntGold = getNumOfGold(i,j,k);
					int benefit = cntGold*m;
					int cost = k*k + (k+1)*(k+1);
					if(benefit>=cost) {
						maxGold = Math.max(maxGold, cntGold);
					}
				}
			}
		}
		System.out.println(maxGold);
	}
}