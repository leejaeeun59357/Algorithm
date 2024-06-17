import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        int number = 1;

        for (int i = 0; i < n; i++) {
            int currentNum = arr[i];
            if(currentNum >= number) {
                while(currentNum >= number) {
                    stack.push(number);
                    sb.append("+\n");
                    number++;
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int x = stack.pop();
                if(x > currentNum) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        
        if(result) {
            System.out.println(sb.toString());
        }
    }
}