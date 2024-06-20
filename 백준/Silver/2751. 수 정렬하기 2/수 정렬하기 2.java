import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] tmp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1, n);
        
        for(int i = 1; i <= n; i++) {
            bw.write(arr[i]+ "\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void merge_sort(int start, int end) {
        if(end - start < 1) {
            return;
        }
        int mid = start +(end - start) / 2;
        merge_sort(start, mid);
        merge_sort(mid + 1, end);
        
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        
        int idx = start;
        int p = start;
        int q = mid + 1;
        
        while(p <= mid && q <= end) {
            if(tmp[p] > tmp[q]) {
                arr[idx++] = tmp[q++];
            } else {
                arr[idx++] = tmp[p++];
            }
        }
        
        while(p <= mid) {
            arr[idx++] = tmp[p++];
        }
        while(q <= end) {
            arr[idx++] = tmp[q++];
        }
    }
}