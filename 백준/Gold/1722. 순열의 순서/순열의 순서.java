import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] value = new long[21];
        value[0] = 1;
        for (int i = 1; i <= 20; i++) {
            value[i] = i * value[i - 1];
        }

        int N = sc.nextInt();
        int num = sc.nextInt();
        boolean[] visited = new boolean[N + 1];
        long answer = 1;
        int[] arr = new int[N+1];
        long k = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if (num == 1) {
            k = sc.nextLong();
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 1; j <= N ; j++) {
                    if(visited[j]) continue;
                    if(k > value[i]) {
                        k -= value[i];
                    } else {
                        list.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        } else if (num == 2) {
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < N; i++) {
                for(int j = 1; j < arr[i]; j++) {
                    if(!visited[j]) {
                        answer += value[N-1-i];
                    }
                }
                visited[arr[i]] = true;
            }
            System.out.println(answer);
        }
    }
}