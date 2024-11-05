import java.util.Scanner;


public class Main {
    public static int n;
    public static int[] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	int minSumMove = Integer.MAX_VALUE;
    	arr = new int[n];
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	
    	for(int i=0;i<n;i++) {
    		int sumMove = 0;
    		for(int j=0;j<n;j++) {
    			sumMove += Math.abs(i-j)*arr[j];
    		}
    		if(sumMove<minSumMove) {
    			minSumMove = sumMove;
    		}
    	}
    	System.out.println(minSumMove);
        
    }
}