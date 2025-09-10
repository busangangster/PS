import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());
      if (tmp == 0) {
        if (pq.isEmpty()) {
          sb.append(0);
        } else {
          sb.append(pq.poll());
        }
        sb.append("\n");

      } else {
        pq.offer(tmp);
      }
    }
    System.out.println(sb);
  }
}