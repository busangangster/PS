import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      Queue<int[]> q = new ArrayDeque<int[]>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        int tmp = Integer.parseInt(st.nextToken());
        pq.offer(tmp);
        q.offer(new int[] { i, tmp });
      }

      int cnt = 1;
      while (!q.isEmpty()) {
        int[] cur = q.poll();
        if (pq.peek() == cur[1]) {
          if (cur[0] == M) {
            break;
          }
          pq.poll();
          cnt++;
        } else {
          q.offer(cur);
        }
      }
      sb.append(cnt).append("\n");

    }
    System.out.println(sb);
  }
}
