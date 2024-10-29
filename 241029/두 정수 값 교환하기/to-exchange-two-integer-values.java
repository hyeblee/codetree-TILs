import java.util.*;



public class Main {

    public static class IntWrapper{
        int number;

        public IntWrapper(int number){
            this.number = number;
        }
    }

    public static void swap(IntWrapper n, IntWrapper m){
        int tmp = n.number;
        n.number = m.number;
        m.number = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntWrapper n = new IntWrapper(sc.nextInt());
        IntWrapper m = new IntWrapper(sc.nextInt());

        swap(n,m);

        System.out.println(n.number + " " + m.number);
    }
}