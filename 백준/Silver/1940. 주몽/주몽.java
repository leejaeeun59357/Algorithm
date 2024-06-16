import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int start_idx = 0;
        int end_idx = N - 1;
        
        while(start_idx != end_idx && start_idx < end_idx) {
      if(arr[start_idx] + arr[end_idx] == M) {
        answer++;
        start_idx++;
        end_idx--;
      } else if (arr[start_idx] + arr[end_idx]  < M ){
        start_idx++;
      } else {
        end_idx--;
      }
    }
        System.out.print(answer);
    }
}