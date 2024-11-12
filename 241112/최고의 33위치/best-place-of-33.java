import java.util.Scanner;

public class Main {
	public static final int MAX_N = 20;

	public static int n;
	public static int[][] arr = new int[MAX_N][MAX_N];
	
	public static int getNumOfGold(int rowS,int colS, int rowE, int colE) {
		int numOfGold = 0;
		
		for(int row = rowS;row<=rowE;row++) {
			for(int col = colS;col<=colE;col++) {
				numOfGold+=arr[row][col];
			}
		}
		return numOfGold;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int maxGold = 0;
		for (int row = 0; row < n; row++) {
			for (int col= 0; col < n; col++) {
				if(row>=n-2||col>=n-2)
					continue;
				int numOfGold = getNumOfGold(row, col, row+2, col+2);
				maxGold = Math.max(maxGold, numOfGold);
			}
		}
		System.out.println(maxGold);
	}
}