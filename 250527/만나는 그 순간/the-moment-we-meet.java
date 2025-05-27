import java.util.Scanner;
import java.util.*;
public class Main {
    public static final int MAX_SIZE = 1000 * 1000;

    // 매 초에 어느 위치에 있었는지 기록하면 됨
    public static int[] a = new int[MAX_SIZE+1];
    public static int[] b = new int[MAX_SIZE+1];
    public static int timeA = 0; // 현재 A의 시간
    public static int timeB = 0; // 현재 B의 시간
    public static int curA = 0;
    public static int curB = 0; // 현재 B의 위치

    // dir, t 
    // 왼쪽으로 t초만큼 이동
    // 현재 위치, 현재 초 필요

    public static void goLeft(int[] arr, int curP, int curT, int t) {
        for(int i=0;i<t;i++){ 
            arr[curT+i+1] = --curP;
        }
    }

    public static void goRight(int[] arr, int curP, int curT, int t) {
        for(int i=0;i<t;i++){ 
            arr[curT+i+1] = ++curP;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxT = 0;
        for(int i=0;i<n;i++){
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();
            maxT += t;
            if(dir=='L'){
                goLeft(a, curA, timeA, t);
                curA -= t;
                timeA += t;
            } else {
                goRight(a, curA, timeA, t);
                curA += t;
                timeA += t;
            }
            // System.out.println("A: "+curA);
        }

         for(int i=0;i<m;i++){
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();
            if(dir=='L'){
                goLeft(b, curB, timeB, t);
                curB -= t;
                timeB += t;
            } else {
                goRight(b, curB, timeB, t);
                curB += t;
                timeB += t;
            }
            // System.out.println(curB);
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        for(int i=1;i<=maxT+1;i++){
            if(a[i]==b[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}