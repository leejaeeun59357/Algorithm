import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split("-");

        long answer = 0;

        for (int i = 0; i < arr.length; i++) {
            long num = change(arr[i]);

            if(i == 0) {
                answer += num;
            } else {
                answer -= num;
            }
        }

        System.out.println(answer);
    }

    private static long change(String s) {
        String[] arr = s.split("\\+");
        long num = 0;
        for (int i = 0; i < arr.length; i++) {
            num += Long.parseLong(arr[i]);
        }
        return num;
    }
}