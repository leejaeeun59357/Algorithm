import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    static int N;
    static int M;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        start = Arrays.stream(A).max().getAsInt();
        end = Arrays.stream(A).sum();
        
        while(start <= end) {
            int mid = (end + start) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if(sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            
            if(sum != 0) {
                count++;
            }
            
            if(count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}