import java.util.Scanner;
public class Main {
    public static class User{
        public String id;
        public String level;
        public User(String id, String level){
            this.id = id;
            this.level = level;
        }

        public void printInfo(){
            System.out.printf("user %s lv %s\n",id,level);
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        String level = sc.next();
        User user1 = new User("codetree", "10");
        User user2 = new User(id,level);
        user1.printInfo();
        user2.printInfo();
    }
}