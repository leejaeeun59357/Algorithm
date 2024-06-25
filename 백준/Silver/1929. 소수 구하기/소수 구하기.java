import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m+1];
        for(int i = 2; i<= m; i++) {
            arr[i] = 1;
        }

        for(int i = 2; i <= Math.sqrt(m); i++) {
            if(arr[i] == 0) {
                continue;
            }
            int num = i+i;
            while(num <= m) {
                arr[num] = 0;
                num += i;
            }
        }
        for(int i = n; i <= m; i++) {
            if(arr[i] == 1) {
                System.out.println(i);
            }
        }
    }
}