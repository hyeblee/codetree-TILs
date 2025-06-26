import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        list.add(first);
        list.add(second);
        for(int i=3;i<=10;i++){
            int third = first + second;
            third %=10;
            list.add(third);
            first = second;
            second = third;
        }
        int[] arr;
        arr = new int[list.size()];
        arr = list.stream().mapToInt(i->i).toArray();
        for(int v:arr){
            System.out.print(v+" ");
        }
    }
}