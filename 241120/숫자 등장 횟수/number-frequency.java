import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
	public static int n,m;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		for(int i=0;i<m;i++) {
			int find = sc.nextInt();
			System.out.print(map.getOrDefault(find,0)+" ");
		}
	}

}