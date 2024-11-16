import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100000;
	public static final int MIN_N = -1000;
	
	public static int n;
	public static int[] arr = new int[MAX_N];
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	n = sc.nextInt();
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	//항상 합이 양수라는 보장은 없음. . .
    	int maxSum = MIN_N;
    	int sum=0;
    	for(int i=0;i<n;i++) {
    		sum+=arr[i];
    		maxSum=Math.max(sum, maxSum);
    		if(sum<0)
    			sum=0;
    	}
    	System.out.println(maxSum);
    }
}