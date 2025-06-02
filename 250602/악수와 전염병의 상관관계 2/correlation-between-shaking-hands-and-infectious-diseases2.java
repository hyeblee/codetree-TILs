import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[] result;
    public static int[] isInfected;

    public static class myComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0],b[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); // k번의 악수동안만 옮기기
        int P = sc.nextInt(); // 첫 감염자
        int T = sc.nextInt();
        result = new int[N+1];
        isInfected = new int[N+1];
        result[T] = K;
        isInfected[T] = 1;
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) { // t초에 x개발자와 y개발자가 악수 
            shakes[i][0] = sc.nextInt(); 
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
        }

        Arrays.sort(shakes, new myComparator());
    
        for(int i=0;i<T;i++) {
            int x = shakes[i][1];
            int y = shakes[i][2];

            if (result[x] > 0) {
                result[x]--;
                if (isInfected[y] == 0) {
                    result[y] = K;
                    isInfected[y] = 1;
                    continue;
                }
            }
            if (result[y] > 0) {
                result[y]--;
                if (isInfected[x] == 0) {
                    result[x] = K;
                    isInfected[x] = 1;
                }
            } 
        }

        // Arrays.stream(shakes).map(Arrays::toString).forEach(System.out::println); // 메서드 참조(람다 표현식 간략하게)
        Arrays.stream(isInfected).forEach(i -> System.out.print(i));
    }
}