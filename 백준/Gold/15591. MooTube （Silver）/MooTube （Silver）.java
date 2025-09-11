import java.io.*;
import java.util.*;

public class Main {
  public static int N, Q, K, V;
  public static ArrayList<ArrayList<int[]>> arr = new ArrayList<ArrayList<int[]>>();
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.get(a).add(new int[] { b, c });
      arr.get(b).add(new int[] { a, c });
    }

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      K = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      visited = new boolean[N + 1];
      int res = bfs(V);
      sb.append(res).append("\n");
    }

    System.out.println(sb);

  }

  public static int bfs(int start) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[start] = true;
    q.offer(new int[] { start, 0 });
    int cnt = 0;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int[] next : arr.get(cur[0])) {
        if (!visited[next[0]] && next[1] >= K) {
          cnt++;
          visited[next[0]] = true;
          q.offer(new int[] { next[0], next[1] });
        }
      }
    }
    return cnt;
  }
}