import java.util.Scanner;


public class Main {
	public static int n;
	public static int[] arr = new int[100];
    public static void main(String[] args) {
    	int minSum = Integer.MAX_VALUE;
    	
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++) {
        	arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++) {
        	int sumDistance = 0;
        	for(int j=0;j<n;j++) {
        		sumDistance += Math.abs(i-j)*arr[j];
        	}
        	minSum = Math.min(sumDistance, minSum);
        }
        System.out.println(minSum);
    }
}