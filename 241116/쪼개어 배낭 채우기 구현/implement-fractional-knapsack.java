import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100000;

	public static int n, m;

	public static class Jewelry implements Comparable<Jewelry> {
		int weight;
		int value;

		public Jewelry(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
		
		public double valuePerWeight() {
			return (double)value/weight;
		}
		// (int)(v1-v2)가 안되는 이유?
		// -0.0031도 0으로 처리하기 때문!
		
		@Override
		public int compareTo(Jewelry o) {
			double v1 = this.valuePerWeight();
			double v2 = o.valuePerWeight();
			return Double.compare(v2, v1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Jewelry[] arr = new Jewelry[n];
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			arr[i] = new Jewelry(w,v);
		}

		Arrays.sort(arr);
		double benefit = 0;
		int idx = 0;
		for(int i=0;i<n;i++) {
			if(arr[idx].weight>m) {
				benefit += m*arr[idx].valuePerWeight();
				break;
			}
			benefit += arr[idx].valuePerWeight()*arr[idx].weight;
			m -= arr[idx].weight;
			idx++;
		}
		System.out.printf("%.3f\n",benefit);
	}

}