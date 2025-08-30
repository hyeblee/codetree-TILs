import java.util.*;
public class Main {
    public static int n, k;
    public static List<Integer> result = new ArrayList<>();
    public static void printResult() {
        for(Integer n: result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void chooseN(int depth) {
        if (depth == n) {
            printResult();
            return;
        }
        if (depth <= 1) {
            for(int i=1;i<=k;i++) {
                result.add(i);
                chooseN(depth+1);
                result.remove(result.size()-1);
            }
        } else {
            int cur = result.get(result.size()-1);
            int before = result.get(result.size()-2);
            boolean isSame = cur == before;
            for(int i=1;i<=k;i++) {
                if (isSame && i==cur) {
                    continue;
                } 
                result.add(i);
                result.add(i);
                chooseN(depth+1);
                result.remove(result.size()-1);
            \}
        \}

    \} 
    // public static 
    // public static 
    // public static 

212public class Main {    public static void chooseN(int depth) {

$0
                chooseN(depth+1);
                result.remove(result.size()-1);
            }
        }

    } 
    // public static 
    // public static 
    // public static 
    // public static 
    // public static 
    // public static 


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        chooseN(0);
        
    }
}