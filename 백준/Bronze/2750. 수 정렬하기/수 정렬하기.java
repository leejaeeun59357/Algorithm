import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i< N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < i ; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        
        for(int i = 0; i< N; i++) {
            System.out.println(arr[i]);
        }
    }
}