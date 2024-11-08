import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_NUM = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] people = new int[MAX_NUM+1];
		
		for(int i=0;i<n;i++) {
			int position = sc.nextInt();
			char alphabet = sc.next().charAt(0);
			//G면 -1,H면 1로 저장
			int value = alphabet=='G'? -1: 1;
			people[position] = value;
		}
		
		int start = MAX_NUM;
		int end = 0;
		int maxRange=0;
		int j;
		for(int i=1;i<=MAX_NUM;i++) {
			int same = 0;
			if(same!=0&&i<start)
				start = i;
			if(same!=0&&i>end)
				end = i;
			for(j=0;j<MAX_NUM && i+j<=end;j++) {
				same += people[i+j];
			}
			if(same==0 && end-start>maxRange) {
				System.out.println(i+"~"+(i+j));
				maxRange = end-start;
			}
		}
		System.out.println(maxRange);
	}
}