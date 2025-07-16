import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_IDX = 200;
    static int n, t, arr[] = new int[MAX_IDX*2];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        t %= (2 * n);

        for(int i=0, k=0; i<2; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                arr[k++] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<t; i++){
            move();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0, k=0; i<2; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[k++]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void move(){
        int temp = arr[2*n-1];
        for(int i=2*n-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}