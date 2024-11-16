import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Main {
	public static final int MAX_N = 100000;
	
	public static ArrayList<Integer> list = new ArrayList<>();
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int n = sc.nextInt();
			list.add(n);
		}
		int totalCost = 0;
		while(list.size()>= 2) {
			Collections.sort(list);
			int cost = list.get(0)+list.get(1);
			totalCost += cost;
			list.add(cost);
			list.remove(0);
			list.remove(1);
		}
		System.out.println(totalCost);
	}

}