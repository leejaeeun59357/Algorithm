import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    char[] arr = br.readLine().toCharArray();

    for(int i = 0; i < arr.length; i++) {
      int maxIdx = i;
      for(int j = i ; j < arr.length-1; j++) {
        if(arr[maxIdx] < arr[j+1]) {
          maxIdx = j+1;
        }
      }
      char tmp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = tmp;
    }

    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
  }
}