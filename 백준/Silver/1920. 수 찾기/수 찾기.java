import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(st.nextToken());
        
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num)) {
                bw.write("1" + "\n");
            } else {
                bw.write("0" + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}