import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 1;
        boolean result = true;

        for (int i = 0; i < n; i++) {
          int currentNum = arr[i];

          // 자연수가 현재 수열의 값보다 작거나 같을 때
          if(currentNum >= number) {
              while(currentNum >= number) {
                  stack.push(number++);
                  sb.append("+\n");
              }
              stack.pop();
              sb.append("-\n");
          } else {    // 현재 수열 값이 자연수보다 작을 때
              int popValue = stack.pop();
              if(popValue > currentNum) {
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