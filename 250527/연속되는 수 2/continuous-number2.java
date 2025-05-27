import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int maxCnt = 0;
        for(int i=0;i<n;i++){
            if(i==0 || arr[i-1]!=arr[i]){
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
            }
            cnt++;
        }
        System.out.println(maxCnt);
    }
}