import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Jewelry implements Comparable<Jewelry> {
	int weight;
	int value;

	public Jewelry(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	public double valuePerWeight() {
		return (double) value / weight;
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

public class Main {
	public static int n, m;
	public static ArrayList<Jewelry> jewels = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Jewelry[] arr = new Jewelry[n];
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			Jewelry jewelry = new Jewelry(w,v);
			jewels.add(jewelry);
		}

		Collections.sort(jewels);
		double benefit = 0;
		for (int i = 0; i < n; i++) {
			int w = jewels.get(i).weight;
			int v = jewels.get(i).value;
			
			if(w>m) {
				benefit += jewels.get(i).valuePerWeight() * m;
				break;
			}
			m-=w;
			benefit += jewels.get(i).valuePerWeight()*w;
		}
		System.out.printf("%.3f\n", benefit);
	}

}