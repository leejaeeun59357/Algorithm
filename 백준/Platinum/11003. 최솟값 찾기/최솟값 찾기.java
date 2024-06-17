import java.util.*;
        import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
            new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Deque<Node> deque = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());

      while (!deque.isEmpty() && deque.getLast().value > now) {
        deque.removeLast();
      }
      deque.addLast(new Node(i, now));

      if (deque.getFirst().index <= i - L) {
        deque.removeFirst();
      }
      bw.write(deque.getFirst().value + " ");
    }
      bw.flush();
      br.close();
  }

  static class Node {
    int index;
    int value;

    Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
