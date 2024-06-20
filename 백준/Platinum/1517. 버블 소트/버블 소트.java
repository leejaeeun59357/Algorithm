import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] tmp;
    static long answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];
        tmp = new int[n+1];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        merge_sort(1, n);
        System.out.println(answer);
    }
    
    private static void merge_sort(int start, int end) {
        if(end - start < 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        
        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        
        int idx = start;
        int p = start;
        int q = mid + 1;
        
        while(p <= mid && q <= end){
            if(tmp[p] > tmp[q]) {
                arr[idx] = tmp[q];
                answer = answer + q - idx;
                idx++;
                q++;
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