import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[10001];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }
        br.close();
        
        for(int i = 1; i <= 10000; i++) {
            if(arr[i] != 0) {
                int cnt = arr[i];
                for(int j = 0; j < cnt; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}