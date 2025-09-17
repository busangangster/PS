import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    sb.append("<");

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      q.offer(i);
    }

    while (q.size() != 1) {
      for (int i = 0; i < k - 1; i++) {
        q.offer(q.poll());
      }

      sb.append(q.poll()).append(", ");
    }

    sb.append(q.peek()).append(">");
    System.out.println(sb);

  }
}