import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int start_index = 1;
    int end_index = 1;
    int[] arr = new int[N+1];
    int sum = 1;
    int answer = 0;

    for(int i = 1; i <= N; i++) {
      arr[i] = i;
    }

    while(end_index < N) {
      if(sum == N) {
        answer += 1;
        end_index += 1;
        sum += arr[end_index];
      } else if(sum < N ) {
        end_index += 1;
        sum += arr[end_index];
      } else {
        sum -= arr[start_index];
        start_index += 1;
      }
    }

    System.out.print(answer +1 );
  }
}