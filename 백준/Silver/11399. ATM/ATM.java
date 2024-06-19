import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
            new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int[] S = new int[n];

    S[0] = arr[0];

    for(int i = 1; i< n; i++) {
      S[i] = S[i-1] + arr[i];
    }
    System.out.print(Arrays.stream(S).sum());
  }
}