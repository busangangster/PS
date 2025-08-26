import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
  public static boolean[] visited;
  public static int[] ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    visited = new boolean[N + 1];
    ans = new int[N + 1];
    bfs();

    for (int i = 2; i <= N; i++) {
      sb.append(ans[i]).append("\n");
    }

    System.out.println(sb);

  }

  public static void bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(1);
    visited[1] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : arr.get(cur)) {
        if (!visited[next]) {
          ans[next] = cur;
          q.offer(next);
          visited[next] = true;
        }
      }
    }
  }
}