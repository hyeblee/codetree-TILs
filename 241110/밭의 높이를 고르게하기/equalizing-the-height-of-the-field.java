import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM=100;
	
	public static int n,t,h;
	public static int[] arr = new int[MAX_NUM];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		h = sc.nextInt();
		t = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			arr[i] = Math.abs(sc.nextInt() - h);
		}

		int minCost = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) { // 탐색 시작 범위
			int cost = 0;
			for(int j = i;j<i+t;j++) { // 탐색 범위 크기 t로 고정해서 탐색
				cost += arr[j];
			}
			minCost = Math.min(cost, minCost);
		}
		
		System.out.println(minCost);
	}
}