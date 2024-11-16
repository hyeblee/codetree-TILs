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
		long totalCost = 0;
		while(list.size()>= 2) {
			Collections.sort(list);
			int cost = list.get(0)+list.get(1);
			totalCost += cost;
			list.add(cost);
			list.remove(0);
			// list.remove(1)하면 원래 인덱스 2가 삭제됨
			// 왜냐면 0이 이미 삭제되서 1이 0이 되었기 떄문..
			if(list.size()>1)
				list.remove(0);
		}
		System.out.println(totalCost);
	}

}