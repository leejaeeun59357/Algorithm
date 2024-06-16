import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            int k = arr[i];
            int start_idx = 0;
            int end_idx = N-1;

            while(start_idx < end_idx) {
               if(arr[start_idx] + arr[end_idx] < k) {
                   start_idx++;
               } else if (arr[start_idx] + arr[end_idx] > k) {
                   end_idx--;
               } else if (arr[start_idx] + arr[end_idx] == k) {
                   if(start_idx != i && end_idx != i) {
                       answer ++;
                       break;
                   } else if (start_idx == i) {
                       start_idx ++;
                   } else if (end_idx == i) {
                       end_idx--;
                   }
               }
            }
        }
        System.out.print(answer);
    }
}