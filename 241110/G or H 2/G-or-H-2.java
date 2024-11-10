import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 100;
	
	public static int n;
	public static int[] arr = new int[MAX_NUM+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int position = sc.nextInt();
			char ch = sc.next().charAt(0);
			int value = ch=='G'? -1 : 1;
			arr[position] = value;
		}
		int maxRange = 0;
		for(int i=0;i<=MAX_NUM;i++) { // 탐색 시작 범위
			for(int j=i;j<=MAX_NUM;j++) { // 탐색 끝 범위
				// 사람 없으면 길이 세면 안되니까 탐색 안함
				if(arr[i]==0||arr[j]==0)
					continue;
				int sum = 0;
				for(int k=i;k<=j;k++) {
					sum+=arr[k];
				}
				if(sum==0 || Math.abs(sum)==n) {
					int range = j-i;
					maxRange = Math.max(maxRange, range);
				}
			}
		}
		System.out.println(maxRange);
		
		
	}
}